package br.com.itau.notificacao.limite.log.service.exception;

public class DadosInvalidosException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5820772526030254254L;

	public DadosInvalidosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DadosInvalidosException(String message) {
		super(message);
	}

	
}
