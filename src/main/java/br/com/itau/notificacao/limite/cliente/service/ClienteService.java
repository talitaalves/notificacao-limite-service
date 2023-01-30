package br.com.itau.notificacao.limite.cliente.service;

import org.springframework.stereotype.Service;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.cliente.repository.ClienteRepository;
import br.com.itau.notificacao.limite.cliente.service.exception.ClienteNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	public Cliente recuperaCliente(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}
}
