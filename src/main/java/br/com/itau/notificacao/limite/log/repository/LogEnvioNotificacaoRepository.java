package br.com.itau.notificacao.limite.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.notificacao.limite.log.domain.entity.LogEnvioNotificacao;

public interface LogEnvioNotificacaoRepository extends JpaRepository<LogEnvioNotificacao, Long> {

}
