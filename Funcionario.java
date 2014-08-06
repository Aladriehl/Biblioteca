
public class Funcionario {

	private DadosPessoal dados;
	private Endereco end;
	private String cargo;
	private double salario;
	

	public Funcionario(DadosPessoal dados, Endereco end, String cargo, double salario) {
		this.dados = dados;
		this.end = end;
		this.cargo = cargo;
		this.salario  = salario;
	}

	public DadosPessoal getDados() {
		return dados;
	}

	public void setDados(DadosPessoal dados) {
		this.dados = dados;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
}
