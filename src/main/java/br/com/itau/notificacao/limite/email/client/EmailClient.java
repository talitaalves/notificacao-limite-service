package br.com.itau.notificacao.limite.email.client;

import org.springframework.stereotype.Component;

import br.com.itau.notificacao.limite.email.config.EmailWebClientConfig;
import br.com.itau.notificacao.limite.email.domain.EmailVO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailClient {

	private final EmailWebClientConfig apilWebClient;
	
	public void sendMail(EmailVO emailVO) {
		this.apilWebClient
		.emailWebClient()
		.post()
		.uri("/email")
		.bodyValue(emailVO)
		.retrieve()
		.toEntity(Void.class)
		.block();
	}
}
