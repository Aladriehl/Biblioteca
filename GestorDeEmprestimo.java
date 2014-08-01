
public class GestorDeEmprestimo {
    /*Metodos de emprestimo de livro pra determinado aluno*/
	public void emprestarPara(Aluno a, Livro livro1) {
		a.emprestarLivro(livro1);		
	}
    public void emprestarPara(Aluno a, Livro livro1, Livro livro2) {
		a.emprestarLivro(livro1);
		a.emprestarLivro(livro2);
		
	}
	public void emprestarPara(Aluno a, Livro livro1, Livro livro2, Livro livro3) {
		a.emprestarLivro(livro1);
		a.emprestarLivro(livro2);
		a.emprestarLivro(livro3);
	}

	public Livro devolverLivro(Aluno a, Livro livro1) {
		return a.devolverLivro(livro1);
	}
	public void aplicarMulta(Aluno a, double valorDaMulta) {
		a.setTemMulta(true);
		a.setMulta(valorDaMulta);
	}
	
	public void removerMulta(Aluno a) {
		a.setTemMulta(false);
		a.setMulta(0);
	}
	
	public void descontarValorDaMulta(Aluno a, double desconto){
		if (a.verificaTemMulta()==true) {
			double multaAtual = a.getMulta();
			double temp = multaAtual - desconto;
			a.setMulta(temp);
		}
	}

}
