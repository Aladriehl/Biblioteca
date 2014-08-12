package com.biblioteca;


public class Funcionario {

	private DadosPessoal dados;
	private Endereço end;
	private String cargo;
	private double salario;
	

	public Funcionario(DadosPessoal dados, Endereço end, String cargo, double salario) {
		this.dados = dados;
		this.end = end;
		this.cargo = cargo;
		this.salario  = salario;
	}

	public DadosPessoal getDados() {
		return dados;
	}

	public void setDados(DadosPessoal dados) {
		this.dados = dados;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Endereço getEnd() {
		return end;
	}

	public void setEnd(Endereço end) {
		this.end = end;
	}
}
