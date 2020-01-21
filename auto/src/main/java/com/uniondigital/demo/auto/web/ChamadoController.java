package com.uniondigital.demo.auto.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniondigital.demo.auto.model.Chamado;
import com.uniondigital.demo.auto.model.ChamadoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class ChamadoController {

    private final Logger log = LoggerFactory.getLogger(ChamadoController.class);
    @Autowired
	private ChamadoRepository chamadoRepository;
    
	public ChamadoController(ChamadoRepository chamadoRepository) {
		this.chamadoRepository = chamadoRepository;
	}
	
	@GetMapping("/chamado")
	@ResponseBody
	public List<Chamado> getChamado(){
		return chamadoRepository.findAll();
	}
	
	@GetMapping("/chamado/{id}")
    public ResponseEntity<Chamado> getChamadoById(@PathVariable Long id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@DeleteMapping("/chamado/{id}")
	public ResponseEntity<Chamado> deleteChamado(@PathVariable Long id){
        log.info("Request to delete chamado: {}", id);
        chamadoRepository.deleteById(id);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/chamado")
	public ResponseEntity<Chamado> deleteAllChamados(){
		log.info("Request to delete all chamados");
		chamadoRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
