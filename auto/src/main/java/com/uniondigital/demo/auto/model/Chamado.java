package com.uniondigital.demo.auto.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "chamado")
@JsonIgnoreProperties
public class Chamado {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "originFile_id", nullable = false)
	private UploadedFiles originFile;
	@NonNull
	private Long numChamado;
	@NonNull
	private String operacao;
	@NonNull
	private String grupo;
	private String subGrupo;
	@NonNull
	private String categorizacao;
	@NonNull
	private String tipificacao;
	@NonNull
	private String recurso;
	@NonNull
	private String severidade;
	@NonNull
	private String statusData;
	@NonNull
	private String tecnologia;
	@NonNull
	private String dataAbertura;
	private String dataFechamento;
	@NonNull
	private String fechado;
	@NonNull
	private double contagemSla;
	@NonNull
	private int metaSla;
	@NonNull
	private double indiceMetaSla;
	@NonNull
	private int contagemSlaHora;


	public Long getId() {
		return id;
	}
	public UploadedFiles getOriginFile() {
		return originFile;
	}
	public void setOriginFile(UploadedFiles originFile) {
		this.originFile = originFile;
	}
	public Long getNumChamado() {
		return numChamado;
	}
	public void setNumChamado(Long numChamado) {
		this.numChamado = numChamado;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getSubGrupo() {
		return subGrupo;
	}
	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}
	public String getCategorizacao() {
		return categorizacao;
	}
	public void setCategorizacao(String categorizacao) {
		this.categorizacao = categorizacao;
	}
	public String getTipificacao() {
		return tipificacao;
	}
	public void setTipificacao(String tipificacao) {
		this.tipificacao = tipificacao;
	}
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public String getSeveridade() {
		return severidade;
	}
	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}
	public String getStatusData() {
		return statusData;
	}
	public void setStatusData(String statusData) {
		this.statusData = statusData;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getFechado() {
		return fechado;
	}
	public void setFechado(String fechado) {
		this.fechado = fechado;
	}
	public double getContagemSla() {
		return contagemSla;
	}
	public void setContagemSla(double contagemSla) {
		this.contagemSla = contagemSla;
	}
	public int getMetaSla() {
		return metaSla;
	}
	public void setMetaSla(int metaSla) {
		this.metaSla = metaSla;
	}
	public double getIndiceMetaSla() {
		return indiceMetaSla;
	}
	public void setIndiceMetaSla(double indiceMetaSla) {
		this.indiceMetaSla = indiceMetaSla;
	}
	public int getContagemSlaHora() {
		return contagemSlaHora;
	}
	public void setContagemSlaHora(int contagemSlaHora) {
		this.contagemSlaHora = contagemSlaHora;
	}


}