package com.uniondigital.demo.auto.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "files")
public class UploadedFiles {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "originFile", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Chamado> chamados = new ArrayList<Chamado>();
	@NonNull
	private String location = "upload-dir";
	@NonNull
	private String name;
	@CreationTimestamp
	private LocalDateTime creationDateTime;

	public Long getId() {
		return id;
	}
	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}
	
	public void addChamado(Chamado chamado) {
		this.chamados.add(chamado);
		chamado.setOriginFile(this);
	}
}