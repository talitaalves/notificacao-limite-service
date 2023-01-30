package br.com.itau.notificacao.limite.log.domain.factory;

import org.springframework.stereotype.Component;

import br.com.itau.notificacao.limite.conta.domain.entity.Conta;
import br.com.itau.notificacao.limite.log.domain.entity.LogEnvioNotificacao;

@Component
public class LogEnvioNotificacaoFactory {

	public LogEnvioNotificacao createFrom(Conta conta, String msg) {
		return LogEnvioNotificacao.builder()
				.cliente(conta.getCliente())
				.conta(conta)
				.mensagem(msg)
				.build();
	}
}
