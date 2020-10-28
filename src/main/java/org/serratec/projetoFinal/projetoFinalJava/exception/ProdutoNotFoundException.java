package org.serratec.projetoFinal.projetoFinalJava.exception;

public class ProdutoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer id;

	public ProdutoNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
