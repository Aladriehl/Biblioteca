package com.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class GerenteEmprestimo {
	private Map<Integer, Aluno> copiaDealunos = new HashMap<Integer, Aluno>();
	private Map<String, Livro> livros = new HashMap<String, Livro>();
	private Map<Integer, Emprestimo> emprestimos = new HashMap<Integer, Emprestimo>();

	public Map<Integer, Aluno> getCopiaDealunos() {
		return copiaDealunos;
	}

	public void setAlunos(Map<Integer, Aluno> copiaDealunos) {
		this.copiaDealunos = copiaDealunos;
	}

	public Map<String, Livro> getLivros() {
		return livros;
	}

	public void setLivros(Map<String, Livro> livros) {
		this.livros = livros;
	}

	public Aluno buscarAluno(int matricula) {
		if (this.copiaDealunos.containsKey(matricula)) {
			return this.copiaDealunos.get(matricula);
		} else {
			lancarExcecao("Aluno não encontrado");
			return null;
		}

	}

	public Livro buscarLivro(String isbnLivro) {
		if (isLivro(isbnLivro)) {
			Livro temp = this.livros.get(isbnLivro);
			return temp;
		} else {
			lancarExcecao("Livro não encontrado");
			return null;
		}
	}

	public boolean isLivro(String isbnLivro) {
		return this.livros.containsKey(isbnLivro);
	}
	
	public Emprestimo buscarEmprestimo(int matricula) {
		if (isEmprestimo(matricula)) {
			return this.emprestimos.get(matricula);
		} else {
			lancarExcecao("Emprestimo não encontrado");
			return null;
		}
	}

	public boolean isEmprestimo(int numeroDeRegistroEmprestimo) {
		return emprestimos.containsKey(numeroDeRegistroEmprestimo);
	}

	public void emprestarLivro(int matriculaDoAluno, String ISBNlivro) {
		Aluno altemp = this.buscarAluno(matriculaDoAluno);
		Livro livtemp = this.buscarLivro(ISBNlivro);
		Emprestimo emptemp = new Emprestimo();
		emptemp.setAluno(altemp);
		emptemp.emprestarLivro(livtemp, matriculaDoAluno);
		this.emprestimos.put(matriculaDoAluno, emptemp);
		this.livros.remove(ISBNlivro, livtemp);
	}

	public void devolverLivro(int matricula, String ISBNLivro) {
		Emprestimo emptemp = this.buscarEmprestimo(matricula);
		Livro livtemp = emptemp.devolverLivro(matricula);
		this.livros.put(ISBNLivro, livtemp);

	}

	public void aplicarMulta(int matricula, double valorMulta) {
		Emprestimo emptemp = this.emprestimos.get(matricula);
		if (valorMulta >= 0.0) {
			emptemp.setMulta(valorMulta);
		} else {
			lancarExcecao("Não pode fornecer um valor em números negativos");
		}
	}

	public void descontoMulta(int numeroDeRegistroEmprestimo,
			double valorDesconto) {
		Emprestimo emptemp = this.emprestimos.get(numeroDeRegistroEmprestimo);
		if (valorDesconto >= 0.0) {
			double temp = emptemp.getMulta();
			temp = temp - valorDesconto;
			emptemp.setMulta(temp);
		}
	}

	private static void lancarExcecao(String msg) {
		throw new BibliotecaException(msg);
	}

}
