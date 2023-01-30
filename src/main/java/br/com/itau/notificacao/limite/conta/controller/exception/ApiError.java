package br.com.itau.notificacao.limite.conta.controller.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ApiError {

	private String status;
	private String mensagem;
	private LocalDateTime timestemp;
	private String codigoErro;
	
	private List<SubErro> erros = new ArrayList<>();

	public ApiError() {
		super();
	}

	public ApiError(String status, String mensagem, LocalDateTime timestemp) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.timestemp = timestemp;
	}

	public ApiError(String status, String mensagem, LocalDateTime timestemp, String codigoErro) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.timestemp = timestemp;
		this.codigoErro = codigoErro;
	}	
}
