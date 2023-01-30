package br.com.itau.notificacao.limite.conta.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NovaMovimentacaoDTO {

	@PositiveOrZero(message="O número da agência não pode ser vazio ou negativo")
	private Long agencia;
	
	@PositiveOrZero(message="O número da conta não pode ser vazio ou negativo")
	private Long numeroConta;
	
	@PositiveOrZero(message="O dígito da conta não pode ser vazio ou negativo")
	private Long digitoConta;
	
	@Positive(message="O valor movimentado deve ser maior que zero")
	@Min(value = 1)
	private Double valorMovimentado;
}
