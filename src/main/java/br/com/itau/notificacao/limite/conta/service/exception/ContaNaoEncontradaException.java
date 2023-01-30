package br.com.itau.notificacao.limite.conta.service.exception;

public class ContaNaoEncontradaException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaNaoEncontradaException(Long id){
		super(
				String.format("Não foi possível localizar um cliente com o id %s informado.",id)
			);
	}
	
	public ContaNaoEncontradaException(String mensagem){
		super(mensagem);
	}
}