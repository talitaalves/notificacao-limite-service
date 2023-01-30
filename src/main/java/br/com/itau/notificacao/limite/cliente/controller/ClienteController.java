package br.com.itau.notificacao.limite.cliente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/cliente")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	
	@GetMapping(value = "/id", produces = "applicaion/json")
	public ResponseEntity<Cliente> listar(){
		return ResponseEntity.ok(this.clienteService.recuperaCliente(1L));
	}
	
}
