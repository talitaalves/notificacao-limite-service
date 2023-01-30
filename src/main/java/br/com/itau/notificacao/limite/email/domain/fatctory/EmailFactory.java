package br.com.itau.notificacao.limite.email.domain.fatctory;

import org.springframework.stereotype.Component;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.email.domain.EmailVO;

@Component
public class EmailFactory {

	public EmailVO createFrom(Cliente cliente) {
		return EmailVO.builder()
				.destinatario(cliente.getEmail())
				.assunto("Notificação de limite excedido.")
				.mensagem("Sua movimentação ultrapassou o seu limite. Deseja aumentá-lo automaticamente? :) ")
				.build();
	}
}
