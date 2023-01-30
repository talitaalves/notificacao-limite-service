package br.com.itau.notificacao.limite.cliente.service.exception;

public class ClienteNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(Long id){
		super(
				String.format("Não foi possível localizar um cliente com o id %s informado.",id)
			);
	}
}
