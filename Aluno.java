package com.biblioteca;

public class Aluno extends Usuario{

	private int matricula;
	private Usuario usario;
	
	
	public Aluno(DadosPessoal dados, Endereço end, int matricula) {
		super(dados, end);
		
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Usuario getUsario() {
		return usario;
	}

	public void setUsario(Usuario usario) {
		this.usario = usario;
	}

	
	
	

}
