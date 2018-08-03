package com.jamerson.socialbooksapi.services.exceptions;

public class AutorExistenteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5672379462162298865L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
