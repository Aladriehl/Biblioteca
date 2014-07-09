
public class Aluno {
	private String nome;
	private double multa;
	private boolean temMulta;
	public void setMulta(){
		this.temMulta=true;
	}
	public boolean getMulta(){
		return this.temMulta;
	}
	public double valorDaMulta(){
		return this.multa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
