package com.uniondigital.demo.auto.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uniondigital.demo.auto.model.Chamado;
import com.uniondigital.demo.auto.model.ChamadoRepository;
import com.uniondigital.demo.auto.model.FilesRepository;
import com.uniondigital.demo.auto.model.UploadedFiles;

@RestController
@RequestMapping("/api")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    
    public FileController(FilesRepository filesRepository) {
    	this.filesRepository = filesRepository;
    }
    
    @GetMapping("/files")
    @ResponseBody
	public List<UploadedFiles> getFiles(){
		return filesRepository.findAll();
	}
    
	@GetMapping("/files/{id}")
    public ResponseEntity<UploadedFiles> getFileById(@PathVariable Long id) {
        Optional<UploadedFiles> file = filesRepository.findById(id);
        return file.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/files/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MultipartFile> uploadFile(@RequestParam(value = "files") MultipartFile file) throws Exception {
        FileService fileService = new FileService(filesRepository, chamadoRepository);
    	fileService.readFile(file);
    	log.info("Files uploaded");
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/files/{id}")
    public ResponseEntity<UploadedFiles> deleteFileById(@PathVariable Long id){
    	log.info("Request to delete file with id " + id + " and its chamados");
    	filesRepository.deleteById(id);
    	return ResponseEntity.ok().build();
    }
}
