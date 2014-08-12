package com.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Emprestimo {
	Aluno aluno;
	int numeroDoEmprestimo;
	int contadorLimite = 3;
	private double multa = 0.0;
	private Map<Integer, Livro> livros = new HashMap<Integer, Livro>();

	public void emprestarLivro(Livro l1, int NumeroDeRegistro) {
		if (this.contadorLimite > 0) {
			livros.put(NumeroDeRegistro, l1);
			contadorLimite--;
		} else {
			lancarExcecao("Limite de livros excedido");
		}
	}

	public Livro devolverLivro(int NumeroDeRegistro) {
		Livro livrotemp = null;
		if (livros.containsKey(NumeroDeRegistro)) {
			livrotemp = livros.get(NumeroDeRegistro);
			livros.remove(NumeroDeRegistro);
			contadorLimite++;
		}
		return livrotemp;
	}

	public Livro buscarLivro(String numeroDeRegistro) {
		if (isLivro(numeroDeRegistro)) {
			return this.livros.get(numeroDeRegistro);
		} else {
			lancarExcecao("Livro não encontrado");
			return null;
		}
	}

	public boolean isLivro(String numeroDeRegistro) {
		return livros.containsKey(numeroDeRegistro);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getNumeroDoEmprestimo() {
		return numeroDoEmprestimo;
	}

	public void setNumeroDoEmprestimo(int numeroDoEmprestimo) {
		this.numeroDoEmprestimo = numeroDoEmprestimo;
	}

	public Map<Integer, Livro> getLivros() {
		return livros;
	}

	public void setLivros(Map<Integer, Livro> livros) {
		this.livros = livros;
	}

	private static void lancarExcecao(String msg) {
		throw new BibliotecaException(msg);
	}

	double getMulta() {
		return multa;
	}

	void setMulta(double multa) {
		this.multa = multa;
	}
}
