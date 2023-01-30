package br.com.itau.notificacao.limite.conta.service;

import org.springframework.stereotype.Service;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.cliente.service.ClienteService;
import br.com.itau.notificacao.limite.conta.domain.NovaContaDTO;
import br.com.itau.notificacao.limite.conta.domain.NovaMovimentacaoDTO;
import br.com.itau.notificacao.limite.conta.domain.factory.ContaFatctory;
import br.com.itau.notificacao.limite.conta.repository.ContaRepository;
import br.com.itau.notificacao.limite.conta.service.exception.ContaJaExisteException;
import br.com.itau.notificacao.limite.conta.service.exception.ContaNaoEncontradaException;
import br.com.itau.notificacao.limite.email.domain.fatctory.EmailFactory;
import br.com.itau.notificacao.limite.envio.service.EnvioNotificacao;
import br.com.itau.notificacao.limite.log.domain.factory.LogEnvioNotificacaoFactory;
import br.com.itau.notificacao.limite.log.service.LogEnvioNotificacaoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor 
public class ContaService {

	private final ClienteService clienteService;
	private final ContaRepository contaRepository;
	private final ContaFatctory contaFatctory;
	private final EnvioNotificacao envioNotificacao;
	private final EmailFactory emailFactory;
	private final LogEnvioNotificacaoService logNotificacaoService;
	private final LogEnvioNotificacaoFactory logFactory;
	
	@Transactional
	public Long save(NovaContaDTO novaContaDTO) {
	
		this.contaRepository.findByAgenciaAndContaAndDigito(novaContaDTO.getAgencia(), novaContaDTO.getNumeroConta(), novaContaDTO.getDigitoConta())
		.ifPresent(conta -> { 
			throw new ContaJaExisteException(conta.getId());
			});
		Cliente cliente = clienteService.recuperaCliente(novaContaDTO.getIdCliente());
		return this.contaRepository.save(
					this.contaFatctory.createFrom(novaContaDTO, cliente)
				).getId();
	}
	
	@Transactional
	public void calculaMovimentacao(NovaMovimentacaoDTO novaMovimentacaoDTO) {
		var conta = contaRepository.findByAgenciaAndContaAndDigito(
				novaMovimentacaoDTO.getAgencia(), 
				novaMovimentacaoDTO.getNumeroConta(),
				novaMovimentacaoDTO.getDigitoConta())
				.orElseThrow(() -> { 
					throw new ContaNaoEncontradaException("Não foi possível localizar a conta com os dados informados");	
				});

		Double limite = 0.0;
		limite = conta.getLimite()+ conta.getSaldo();
		if(limite < novaMovimentacaoDTO.getValorMovimentado()) {
			
			this.envioNotificacao.enviaEmail(emailFactory.createFrom(conta.getCliente()));
			logNotificacaoService.salvarLog(logFactory.createFrom(conta,"Limite excedido 2."));
		}
		
	}
}
