
public class Biblioteca {
	
	private GerenteUsuario gerenteUsuario;
	private GerenteFuncionario gerenteFuncionario;
	private GerenteLivro gerenteLivro;
	
	public Biblioteca(){
		this.gerenteLivro = new GerenteLivro();
		this.gerenteUsuario = new GerenteUsuario();
		this.gerenteFuncionario = new GerenteFuncionario();
	}

	public GerenteUsuario getGerenteUsuario() {
		return gerenteUsuario;
	}

	public void setGerenteUsuario(GerenteUsuario gerenteUsuario) {
		this.gerenteUsuario = gerenteUsuario;
	}

	public GerenteFuncionario getGerenteFuncionario() {
		return gerenteFuncionario;
	}

	public void setGerenteFuncionario(GerenteFuncionario gerenteFuncionario) {
		this.gerenteFuncionario = gerenteFuncionario;
	}

	public GerenteLivro getGerenteLivro() {
		return gerenteLivro;
	}

	public void setGerenteLivro(GerenteLivro gerenteLivro) {
		this.gerenteLivro = gerenteLivro;
	}
	
	
}
