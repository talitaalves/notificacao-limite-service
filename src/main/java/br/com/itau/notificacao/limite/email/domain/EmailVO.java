package br.com.itau.notificacao.limite.email.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailVO {

	@NotNull(message = "O campo destinatário não pode ser nulo.")
	private String destinatario;
	@NotNull(message = "O campo mensagem não pode ser nulo.")
	private String mensagem;
	@NotNull(message = "O campo assunto não pode ser nulo.")
	private String assunto;
}
