package br.com.cdb.bancodigital.exceptions;

public class ValidacoesException extends Exception {
   private static final long serialVersionUID = 1L;

	public ValidacoesException(String mensagem) {
        super(mensagem);
    }
}