package com.biblioteca;

public class Usuario {

	private DadosPessoal dados;
	private Endereço end;

    public Usuario(DadosPessoal dados, Endereço end) {
		this.dados = dados;
		this.end = end;
	}

	public DadosPessoal getDados() {
		return dados;
	}

	public void setDados(DadosPessoal dados) {
		this.dados = dados;
	}

	public Endereço getEnd() {
		return end;
	}

	public void setEnd(Endereço end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Usuario [" +dados.toString() + ", end=" + end.toString() + "]";
	}
	
	

}
