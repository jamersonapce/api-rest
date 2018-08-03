package com.jamerson.socialbooksapi.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955002487887641809L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
