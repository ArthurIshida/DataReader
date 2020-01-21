package com.uniondigital.demo.auto.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.uniondigital.demo.auto.model.Chamado;
import com.uniondigital.demo.auto.model.ChamadoRepository;
import com.uniondigital.demo.auto.model.FilesRepository;
import com.uniondigital.demo.auto.model.UploadedFiles;

public class FileService {
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private FilesRepository filesRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public FileService(FilesRepository filesRepository, ChamadoRepository chamadoRepository) {
		this.filesRepository = filesRepository;
		this.chamadoRepository = chamadoRepository;
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
				String fields[] = line.split(";");
				
				if(fields.length != 17) {
					throw new Exception("Number of columns not accepted");						
				}
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
							chamado.setIndiceMetaSla(Double.parseDouble(fields[15]));
							chamado.setContagemSlaHora(Integer.parseInt(fields[16]));
							uploadedFiles.addChamado(chamado);
							chamadoRepository.save(chamado);
							
						}catch(NumberFormatException e) {
							throw new NumberFormatException("Columns with wrong format");
						}
					}
					lineNumber++;
				}
			}
			log.info("N° de chamados criados: " + (lineNumber - 1));
			
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
