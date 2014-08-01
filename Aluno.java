import java.util.ArrayList;
public class Aluno implements Comparable<Aluno> {
	
	private String nome;
	private String matricula;
	private double multa;
	private boolean temMulta;
	private ArrayList<Livro> listaDeLivrosDoAluno= new ArrayList<Livro> () ;
	
	/*construtor padrão*/
	public Aluno(){ }
	/*construtor passando só nome e matricula*/
	public Aluno(String nome, String matricula){
		setNome(nome);
		setMatricula(matricula);
	}
	/*construtor passando só nome, matricula e o valor da multa*/
	public Aluno(String nome, String matricula, double multa){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
	}
	/*construtor passando só nome, matricula, valor da multa e um livro*/
	public Aluno(String nome, String matricula, double multa, Livro livro1){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
		emprestarLivro(livro1);
	}
	/*construtor passando só nome, matricula, valor da multa e dois livros*/
	public Aluno(String nome, String matricula, double multa, Livro livro1, Livro livro2){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
		emprestarLivro(livro1);
		emprestarLivro(livro2);
	}
	/*construtor passando só nome, matricula, valor da multa e três livros*/
	public Aluno(String nome, String matricula, double multa, Livro livro1, Livro livro2, Livro livro3){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
		emprestarLivro(livro1);
		emprestarLivro(livro2);
		emprestarLivro(livro3);
	}
	
	/*gets e sets*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getMulta() {
		return multa;
	}
	public void setMulta(double multa) {
		this.multa = multa;
	}
	public boolean verificaTemMulta() {
		return temMulta;
	}
	public void setTemMulta(boolean temMulta) {
		this.temMulta = temMulta;
	}
	
	/*metodos*/
	
	/*adicionar livro na lista ali em cima*/
	public void emprestarLivro(Livro livro){
		this.listaDeLivrosDoAluno.add(livro);
	}
	
	/*retorna qual o livro da posição que vc informar*/
	public Livro livroNaPosicaoEh(int posicao){
		return this.listaDeLivrosDoAluno.get(posicao);
	}
	/*remove o livro da posição que vc informar*/
	public void removerPorIndex(int index){
		this.listaDeLivrosDoAluno.remove(index);
		
	}
	/*esse método apaga o livro permanentemente da lista de alunos*/
	public void removerLivro(Livro livro){
		if(this.listaDeLivrosDoAluno.contains(livro)){
			this.listaDeLivrosDoAluno.remove(livro);
		}		
	}
	/*esse metodo devolve um livro pra classe que pediu e retira ele da lista de livros de aluno*/
	public Livro devolverLivro(Livro livro){
		if(this.listaDeLivrosDoAluno.contains(livro)){
			this.listaDeLivrosDoAluno.remove(livro);
		}
		return livro;
	}
	
	/*esse aqui só verifica se dentro da lista tem o livro que foi fornecido como parâmetro*/
	public Livro contemLivro(Livro livro){
		if(listaDeLivrosDoAluno.contains(livro)){
			return livro;
		} else {
			return null;
		}
	}
	
	/*ainda não implementado*/
	public int compareTo(Aluno o) {
		
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((listaDeLivrosDoAluno == null) ? 0 : listaDeLivrosDoAluno
						.hashCode());
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		long temp;
		temp = Double.doubleToLongBits(multa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (temMulta ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (listaDeLivrosDoAluno == null) {
			if (other.listaDeLivrosDoAluno != null)
				return false;
		} else if (!listaDeLivrosDoAluno.equals(other.listaDeLivrosDoAluno))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (Double.doubleToLongBits(multa) != Double
				.doubleToLongBits(other.multa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (temMulta != other.temMulta)
			return false;
		return true;
	}
}
