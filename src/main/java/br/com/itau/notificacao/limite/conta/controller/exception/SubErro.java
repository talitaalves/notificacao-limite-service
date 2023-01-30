package br.com.itau.notificacao.limite.conta.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubErro {

	private String objeto;
	private String campo;
	private Object valorRejeitado;
	private String mensagem;
}
