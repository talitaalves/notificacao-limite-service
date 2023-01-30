package br.com.itau.notificacao.limite.conta.service.exception;

public class ContaJaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaJaExisteException(Long id){
		super(
				String.format("Não foi possível localizar um cliente com o id %s informado.",id)
			);
	}
}
