package com.uniondigital.demo.auto.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
	Chamado findByOperacao(String operacao);
	Chamado findByGrupo(String grupo);
	Chamado findBySubGrupo(String subGrupo);
	Chamado findByCategorizacao(String categorizacao);
	Chamado findByTipificacao(String tipificacao);
	Chamado findByRecurso(String recurso);
	Chamado findBySeveridade(String severidade);
	Chamado findByStatusData(String statusData);
	Chamado findByTecnologia(String tecnologia);
	Chamado findByOriginFileChamado(Optional<UploadedFiles> file);
	/*@Query(nativeQuery = true, value = "SELECT status, dataAbertura, dataFechamento, recurso, operacao FROM Chamado"
			+ "GROUP BY operacao")
	List<Chamado> abertosFechadosOperacao();
	
	@Query(nativeQuery = true, value = "SELECT nome, planejado, realizado"
			+ "	FROM Recurso")
	List<Recurso> realizadasPlanejadas();
	
	@Query(nativeQuery = true, value = "SELECT tipificacao, recurso, operacao, count(numChamado)"
			+ "	FROM Chamado")
	List<Chamado> incidentesOperacao();
	
	@Query(nativeQuery = true, value = "SELECT nome, faturamentoBruto, faturamentoPlanejado	"
			+ "	FROM Recurso")
	List<Chamado> faturamentoPlanejadoRealizado();
	
	@Query(nativeQuery = true, value = "SELECT status, dataAbertura, metaSla, contagemSla, recurso, operacao, count(numChamado)"
			+ "	FROM Chamado ")
	List<Chamado> abertosSlaEstourado();
	
	@Query(nativeQuery = true, value = "SELECT nome, chamadosEncerrados, chamadosEncerradosHora, valorColaborador, count(id)"
			+ "	FROM Recurso ")
	List<Chamado> chamadoEncerradoHoraValorRecurso();
	
	@Query(nativeQuery = true, value = "SELECT status, dataAbertura, dataFechamento, recurso, operacao, metaSla, contagemSla, count(numChamado)"
			+ "	FROM Chamado")
	List<Chamado> abertosAnteriorSlaEstourado();
	
	@Query(nativeQuery = true, value = "SELECT nome, horaChamadoEstimada, horaChamadoApontada"
			+ "	FROM Recurso")
	List<Chamado> chamadoHoraEstimada();
	
	@Query(nativeQuery = true, value = "SELECT status, dataAbertura, dataFechamento, recurso, operacao,"
			+ "	metaSla, contagemSla, tecnologia, count(id)"
			+ "	FROM Chamado")
	List<Chamado> abertoTecnologia();*/
}
