
public class Livros {
	private String titulo;
	private String autor;
	private String anoDePublicação;
	private String editora;
	private String isbn;
	private boolean estaDisponivel;
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
	public String getAnoDePublicação() {
		return anoDePublicação;
	}
	public void setAnoDePublicação(String anoDePublicação) {
		this.anoDePublicação = anoDePublicação;
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
	public boolean isEstaDisponivel() {
		return estaDisponivel;
	}
	public void setEstaDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}
}
