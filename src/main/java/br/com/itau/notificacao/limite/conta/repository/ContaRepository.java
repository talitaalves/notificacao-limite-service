package br.com.itau.notificacao.limite.conta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.itau.notificacao.limite.conta.domain.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	@Query(
			 "SELECT "
			+" conta "
			+" FROM "
			+ " Conta conta "
			+ "WHERE "
			+ " conta.agencia = :agencia "
			+ "AND "
			+ " conta.numeroConta = :numeroConta "
			+ "AND "
			+ " conta.digitoConta = :digitoConta"
			)
	Optional<Conta> findByAgenciaAndContaAndDigito(
			@Param("agencia") Long agencia, 
			@Param("numeroConta") Long numeroConta,
			@Param("digitoConta") Long digitoConta
			);

}
