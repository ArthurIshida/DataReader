package com.uniondigital.demo.auto.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uniondigital.demo.auto.model.Recurso;
import com.uniondigital.demo.auto.model.RecursoRepository;

@RestController
@RequestMapping("/api")
class RecursoController {
    private final Logger log = LoggerFactory.getLogger(ChamadoController.class);
    @Autowired
    private final RecursoRepository recursoRepository;
    
    public RecursoController(RecursoRepository recursoRepository) {
    	this.recursoRepository = recursoRepository;
    }
    
    @GetMapping("/recurso")
    @ResponseBody
    public List<Recurso> getRecursos(){
    	return recursoRepository.findAll();
    }
	
    @GetMapping("/recurso/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id){
    	Optional<Recurso> recurso = recursoRepository.findById(id);
    	return recurso.map(response -> ResponseEntity.ok().body(response))
    			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/recurso/{id}")
    public ResponseEntity<Recurso> deleteRecursoById(@PathVariable Long id){
    	log.info("Request to delete recurso with id: " + id);
    	recursoRepository.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/recurso")
    public ResponseEntity<Recurso> deleteAllRecursos(){
    	log.info("Request to delete all recursos");
    	recursoRepository.deleteAll();
    	return ResponseEntity.ok().build();
    }
}
