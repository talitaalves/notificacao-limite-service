package br.com.itau.notificacao.limite.conta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.notificacao.limite.conta.domain.NovaContaDTO;
import br.com.itau.notificacao.limite.conta.domain.NovaMovimentacaoDTO;
import br.com.itau.notificacao.limite.conta.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/conta")
@RequiredArgsConstructor
public class ContaController {

	private final ContaService contaService;
	
	@PostMapping(produces = "application/json")
	@Operation(summary = "Cria uma nova conta")
	public ResponseEntity<Long> conta(@RequestBody NovaContaDTO novaContaDTO){
		return ResponseEntity.ok(this.contaService.save(novaContaDTO));
	}
	
	@PostMapping(path = "/movimentacao",produces = "application/json")
	@Operation(summary = "Recebe uma movimentacao")
	public void conta(@RequestBody NovaMovimentacaoDTO novaMovimentacaoDTO){
		this.contaService.calculaMovimentacao(novaMovimentacaoDTO);
	}
}
