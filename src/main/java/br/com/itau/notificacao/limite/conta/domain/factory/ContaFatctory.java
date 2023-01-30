package br.com.itau.notificacao.limite.conta.domain.factory;

import org.springframework.stereotype.Component;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.conta.domain.NovaContaDTO;
import br.com.itau.notificacao.limite.conta.domain.entity.Conta;

@Component
public class ContaFatctory {

	public Conta createFrom(NovaContaDTO novaContaDTO, Cliente cliente) {
		return new Conta(
				novaContaDTO.getAgencia(),
				novaContaDTO.getNumeroConta(),
				novaContaDTO.getDigitoConta(), 
				novaContaDTO.getLimite(), 
				novaContaDTO.getSaldo(), 
				cliente);
	}
}
