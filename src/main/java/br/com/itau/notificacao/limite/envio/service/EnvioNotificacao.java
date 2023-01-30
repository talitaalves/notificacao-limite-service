package br.com.itau.notificacao.limite.envio.service;

import org.springframework.stereotype.Service;

import br.com.itau.notificacao.limite.email.client.EmailClient;
import br.com.itau.notificacao.limite.email.domain.EmailVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnvioNotificacao {

	private final EmailClient emailClient;
	
	public void enviaEmail(EmailVO emailVO) {
		try {
			this.emailClient.sendMail(emailVO);	
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
	}
}
