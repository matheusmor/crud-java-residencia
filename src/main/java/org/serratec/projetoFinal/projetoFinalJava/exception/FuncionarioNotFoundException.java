package org.serratec.projetoFinal.projetoFinalJava.exception;

public class FuncionarioNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;

	public FuncionarioNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
