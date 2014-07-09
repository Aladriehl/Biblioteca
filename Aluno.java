import java.util.ArrayList;
public class Aluno {
	private String nome;
	private String matricula;
	private double multa;
	private boolean temMulta;
	private ArrayList<Livro> listaDeLivrosDoAluno= new ArrayList<Livro> () ;
	
	/*construtor padrão*/
	public Aluno(){
		
	}
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
		adicionarLivro(livro1);
	}
	/*construtor passando só nome, matricula, valor da multa e dois livros*/
	public Aluno(String nome, String matricula, double multa, Livro livro1, Livro livro2){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
		adicionarLivro(livro1);
		adicionarLivro(livro2);
	}
	/*construtor passando só nome, matricula, valor da multa e três livros*/
	public Aluno(String nome, String matricula, double multa, Livro livro1, Livro livro2, Livro livro3){
		setNome(nome);
		setMatricula(matricula);
		setMulta(multa);
		adicionarLivro(livro1);
		adicionarLivro(livro2);
		adicionarLivro(livro3);
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
	public void adicionarLivro(Livro livro){
		this.listaDeLivrosDoAluno.add(livro);
	}
	
	/*retorna qual o livro da posição que vc informar*/
	public Livro livroNaPosicaoEh(int posicao){
		return this.listaDeLivrosDoAluno.get(posicao);
	}
	/*remove o livro da posição que vc informar*/
	public void remover(int index){
		this.listaDeLivrosDoAluno.remove(index);
		
	}
	
	
	
}
