package br.com.itau.notificacao.limite.conta.domain;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NovaContaDTO {

	@PositiveOrZero(message="O número da agência não pode ser vazio ou negativo")
	private Long agencia;
	
	@PositiveOrZero(message="O número da conta não pode ser vazio ou negativo")
	private Long numeroConta;
	
	@PositiveOrZero(message="O dígito da conta não pode ser vazio ou negativo")
	private Long digitoConta;
	
	@PositiveOrZero(message="O código do cliente pode ser vazio ou negativo")
	private Long idCliente;
	
	@PositiveOrZero(message="O limite do cliente deve ser maior ou igual a zero")
	private Double limite;
	
	@PositiveOrZero(message="O saldo do cliente deve ser maior ou igual a zero")
	private Double saldo;
}
