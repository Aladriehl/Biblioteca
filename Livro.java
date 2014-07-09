
public class Livro {
	private String titulo;
	private String autor;
	private String anoDePublicacao;
	private String editora;
	private String isbn;
	private boolean Disponivel=true;
	/**/
	/*construtor padrão*/
	public Livro(){
		setTitulo("Titulo padrão");
		setAutor("Autor padrão");
		setAnoDePublicacao("Ano de publicação");
		setEditora("Editora padrão");
		setIsbn("000-000-0");
		setDisponivel(false);
	}
	
	/*construtor passando os valores*/
	public Livro(String titulo,String autor, String anoDePublicacao, String editora, String isbn){
		setTitulo(titulo);
		setAutor(autor);
		setAnoDePublicacao(anoDePublicacao);
		setEditora(editora);
		setIsbn(isbn);
		setDisponivel(false);
	}
	/*metodos*/
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isDisponivel() {
		return Disponivel;
	}
	public void setDisponivel(boolean estaDisponivel) {
		this.Disponivel = estaDisponivel;
	}
	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(String anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
}
