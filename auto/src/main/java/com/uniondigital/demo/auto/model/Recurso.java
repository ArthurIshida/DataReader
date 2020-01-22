package com.uniondigital.demo.auto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Recurso")
public class Recurso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "originFileRecurso_id", nullable = false)
	private UploadedFiles originFileRecurso;
	@NonNull
	private String nome;
	@NonNull
	private double custoHora;
	@NonNull
	private double vendaHora;
	@NonNull
	private double vendaHoraLiq;
	@NonNull
	private double margem;
	@NonNull
	private int chamadosPlanejados;
	@NonNull
	private int chamadosRealizados;
	@NonNull
	private double faturamentoBruto;
	@NonNull
	private double faturamentoPlanejado;
	@NonNull
	private double brutoPlan;
	@NonNull
	private double valor;
	@NonNull
	private int chamadosEncerrados;
	@NonNull
	private double chamadosEncerradosHora;
	@NonNull
	private double valorColaborador;
	@NonNull
	private double horaChamadoHoraEstimada;
	@NonNull
	private double horaChamadoHoraApontada;
	
	public UploadedFiles getOriginFileRecurso() {
		return originFileRecurso;
	}
	public void setOriginFileRecurso(UploadedFiles originFileRecurso) {
		this.originFileRecurso = originFileRecurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCustoHora() {
		return custoHora;
	}
	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}
	public double getVendaHora() {
		return vendaHora;
	}
	public void setVendaHora(double vendaHora) {
		this.vendaHora = vendaHora;
	}
	public double getVendaHoraLiq() {
		return vendaHoraLiq;
	}
	public void setVendaHoraLiq(double vendaHoraLiq) {
		this.vendaHoraLiq = vendaHoraLiq;
	}
	public double getMargem() {
		return margem;
	}
	public void setMargem(double margem) {
		this.margem = margem;
	}
	public int getChamadosPlanejados() {
		return chamadosPlanejados;
	}
	public void setChamadosPlanejados(int chamadosPlanejados) {
		this.chamadosPlanejados = chamadosPlanejados;
	}
	public int getChamadosRealizados() {
		return chamadosRealizados;
	}
	public void setChamadosRealizados(int chamadosRealizados) {
		this.chamadosRealizados = chamadosRealizados;
	}
	public double getFaturamentoBruto() {
		return faturamentoBruto;
	}
	public void setFaturamentoBruto(double faturamentoBruto) {
		this.faturamentoBruto = faturamentoBruto;
	}
	public double getFaturamentoPlanejado() {
		return faturamentoPlanejado;
	}
	public void setFaturamentoPlanejado(double faturamentoPlanejado) {
		this.faturamentoPlanejado = faturamentoPlanejado;
	}
	public double getBrutoPlan() {
		return brutoPlan;
	}
	public void setBrutoPlan(double brutoPlan) {
		this.brutoPlan = brutoPlan;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getChamadosEncerrados() {
		return chamadosEncerrados;
	}
	public void setChamadosEncerrados(int chamadosEncerrados) {
		this.chamadosEncerrados = chamadosEncerrados;
	}
	public double getChamadosEncerradosHora() {
		return chamadosEncerradosHora;
	}
	public void setChamadosEncerradosHora(double chamadosEncerradosHora) {
		this.chamadosEncerradosHora = chamadosEncerradosHora;
	}
	public double getValorColaborador() {
		return valorColaborador;
	}
	public void setValorColaborador(double valorColaborador) {
		this.valorColaborador = valorColaborador;
	}
	public double getHoraChamadoHoraEstimada() {
		return horaChamadoHoraEstimada;
	}
	public void setHoraChamadoHoraEstimada(double horaChamadoEstimada) {
		this.horaChamadoHoraEstimada = horaChamadoEstimada;
	}
	public double getHoraChamadoHoraApontada() {
		return horaChamadoHoraApontada;
	}
	public void setHoraChamadoHoraApontada(double horaChamadoApontada) {
		this.horaChamadoHoraApontada = horaChamadoApontada;
	}
	public Long getId() {
		return id;
	}
}
