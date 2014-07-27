
public class GestorDeEmprestimo {
    public void emprestarPara(Aluno a, Livro livro1) {
		a.adicionarLivro(livro1);		
	}

	public void devolverLivro(Aluno a, Livro livro1) {
		a.removerLivro(livro1);
		
	}

	public void emprestarPara(Aluno a, Livro livro1, Livro livro2) {
		a.adicionarLivro(livro1);
		a.adicionarLivro(livro2);
		
	}
	public void emprestarPara(Aluno a, Livro livro1, Livro livro2, Livro livro3) {
		a.adicionarLivro(livro1);
		a.adicionarLivro(livro2);
		a.adicionarLivro(livro3);
		
	}

	public void devolverLivro(Aluno a, Livro livro1, Livro livro2) {
		a.removerLivro(livro1);
		a.removerLivro(livro2);
		
	}

}
