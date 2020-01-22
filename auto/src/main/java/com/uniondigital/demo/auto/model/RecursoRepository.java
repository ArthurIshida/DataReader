package com.uniondigital.demo.auto.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso, Long>{
	Recurso findByNome(String nome);
}
