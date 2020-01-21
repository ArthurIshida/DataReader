package com.uniondigital.demo.auto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Recurso")
public class Recurso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nome;
	@NonNull
	private double custoHora;
	@NonNull
	private double vendaHora;
	@NonNull
	private double vendaHhLiq;
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
	private double horaChamadoEstimada;
	@NonNull
	private double horaChamadoApontada;
	
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
	public double getVendaHhLiq() {
		return vendaHhLiq;
	}
	public void setVendaHhLiq(double vendaHhLiq) {
		this.vendaHhLiq = vendaHhLiq;
	}
	public double getMargem() {
		return margem;
	}
	public void setMargem(double margem) {
		this.margem = margem;
	}
	public int getPlanejado() {
		return chamadosPlanejados;
	}
	public void setPlanejado(int planejado) {
		this.chamadosPlanejados= planejado;
	}
	public int getRealizado() {
		return chamadosRealizados;
	}
	public void setRealizado(int realizado) {
		this.chamadosRealizados = realizado;
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
	public double getValorColaborado() {
		return valorColaborador;
	}
	public void setValorColaborado(double valorColaborado) {
		this.valorColaborador = valorColaborado;
	}
	public double getHoraChamadoPorHoraEstimada() {
		return horaChamadoEstimada;
	}
	public void setHoraChamadoPorHoraEstimada(double horaChamadoPorHoraEstimada) {
		this.horaChamadoEstimada = horaChamadoPorHoraEstimada;
	}
	public double getHoraChamadoPorHoraApontada() {
		return horaChamadoApontada;
	}
	public void setHoraChamadoPorHoraApontada(double horaChamadoPorHoraApontada) {
		this.horaChamadoApontada = horaChamadoPorHoraApontada;
	}
	public Long getId() {
		return id;
	}
}
