package com.uniondigital.demo.auto.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.uniondigital.demo.auto.model.Chamado;
import com.uniondigital.demo.auto.model.ChamadoRepository;
import com.uniondigital.demo.auto.model.UploadedFilesRepository;
import com.uniondigital.demo.auto.model.Recurso;
import com.uniondigital.demo.auto.model.RecursoRepository;
import com.uniondigital.demo.auto.model.UploadedFiles;

public class FileService {
	private static final Logger log = LoggerFactory.getLogger(FileService.class);
	@Autowired
	private UploadedFilesRepository filesRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private RecursoRepository recursoRepository;
	
	public FileService(UploadedFilesRepository filesRepository, ChamadoRepository chamadoRepository, RecursoRepository recursoRepository) {
		this.filesRepository = filesRepository;
		this.chamadoRepository = chamadoRepository;
		this.recursoRepository = recursoRepository;
	}
	
	public void readFile(MultipartFile file) throws IOException{
		log.info("Reading files");

		FileOutputStream fos;
		FileInputStream inputStream = null;
		Scanner scanner = null;
		UploadedFiles uploadedFiles = new UploadedFiles();
		int lineNumber;
		
		try {
			File convFile = new File(file.getOriginalFilename());
			fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			
			if(filesRepository.count() != 0) {
				log.info("Overwriting existent file");
				filesRepository.deleteById(filesRepository.findByLocation(convFile.getAbsolutePath()).getId());
			}
			
			uploadedFiles.setLocation(convFile.getAbsolutePath());
			uploadedFiles.setName(convFile.getName());
			
			filesRepository.save(uploadedFiles);

			log.info("\nName of File: " + uploadedFiles.getName() +
						"\nLocation of File: " + uploadedFiles.getLocation() +
						"\nID of File: " + uploadedFiles.getId());

			inputStream = new FileInputStream(uploadedFiles.getLocation());
			scanner = new Scanner(inputStream, "UTF-8");
			lineNumber = 0;
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String fields[] = line.replace(".", "").replace(",", ".").replace("%", "").replace("R$ ", "").split(";");
				if(fields.length == 17) {
					if(!line.isEmpty()) {
						if(lineNumber > 0) {
							try {
								Chamado chamado = new Chamado();
								chamado.setNumChamado(Long.parseLong(fields[0]));
								chamado.setOperacao(fields[1]);
								chamado.setGrupo(fields[2]);
								chamado.setSubGrupo(fields[3]);
								chamado.setCategorizacao(fields[4]);
								chamado.setTipificacao(fields[5]);
								chamado.setRecurso(fields[6]);
								chamado.setSeveridade(fields[7]);
								chamado.setStatusData(fields[8]);
								chamado.setTecnologia(fields[9]);
								chamado.setDataAbertura(fields[10]);
								chamado.setDataFechamento(fields[11]);
								chamado.setFechado(fields[12]);
								chamado.setContagemSla(Double.parseDouble(fields[13]));
								chamado.setMetaSla(Integer.parseInt(fields[14]));
								chamado.setIndiceMetaSla(Integer.parseInt(fields[15]));
								chamado.setContagemSlaHora(Integer.parseInt(fields[16]));
								uploadedFiles.addChamado(chamado);
								chamadoRepository.save(chamado);
								
							}catch(NumberFormatException e) {
								throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Fields does no match expected values");
							}
						}
						lineNumber++;
					}
				}
				if(fields.length == 16) {
					if(!line.isEmpty()) {
						if(lineNumber > 0) {
							try {
								Recurso recurso = new Recurso();
								recurso.setNome(fields[0]);
								recurso.setCustoHora(Double.parseDouble(fields[1]));
								recurso.setVendaHora(Double.parseDouble(fields[2]));
								recurso.setVendaHoraLiq(Double.parseDouble(fields[3]));
								recurso.setMargem(Double.parseDouble(fields[4]));
								recurso.setChamadosPlanejados(Integer.parseInt(fields[5]));
								recurso.setChamadosRealizados(Integer.parseInt(fields[6]));
								recurso.setFaturamentoBruto(Double.parseDouble(fields[7]));
								recurso.setFaturamentoPlanejado(Double.parseDouble(fields[8]));
								recurso.setBrutoPlan(Double.parseDouble(fields[9]));
								recurso.setValor(Double.parseDouble(fields[10]));
								recurso.setChamadosEncerrados(Integer.parseInt(fields[11]));
								recurso.setChamadosEncerradosHora(Double.parseDouble(fields[12]));
								recurso.setValorColaborador(Double.parseDouble(fields[13]));
								recurso.setHoraChamadoHoraEstimada(Double.parseDouble(fields[14]));
								recurso.setHoraChamadoHoraApontada(Double.parseDouble(fields[15]));
								uploadedFiles.addRecurso(recurso);
								recursoRepository.save(recurso);
								
							}catch(NumberFormatException e) {
								throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Fields does no match expected values");
							}
						}
						lineNumber++;
					}						
				}
				if(fields.length != 17 && fields.length != 16){
					throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED, "Columns does match expected quantity");
				}
			}
			log.info("N° de chamados criados: " + (lineNumber - 1));
	    	log.info("Files uploaded");
			if(scanner.ioException() != null) {
				throw scanner.ioException();
			}
			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(scanner != null) {
				scanner.close();
			}
		}
	}
}
