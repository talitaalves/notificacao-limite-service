package br.com.itau.notificacao.limite.log.service;

import org.springframework.stereotype.Service;

import br.com.itau.notificacao.limite.log.domain.entity.LogEnvioNotificacao;
import br.com.itau.notificacao.limite.log.repository.LogEnvioNotificacaoRepository;
import br.com.itau.notificacao.limite.log.service.exception.DadosInvalidosException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogEnvioNotificacaoService {

	private final LogEnvioNotificacaoRepository logEnvioNotificacaoRepository;
	
	public void salvarLog(LogEnvioNotificacao logEnvioNotificacao) {
		
		if(logEnvioNotificacao.getCliente() == null 
		|| logEnvioNotificacao.getConta() == null 
		|| logEnvioNotificacao.getMensagem().isEmpty())
			throw new DadosInvalidosException("Verifique os dados. Todos os campos são obrigatórios");
		
		logEnvioNotificacaoRepository.save(logEnvioNotificacao);
	}
}
