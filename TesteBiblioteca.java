package com.biblioteca;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TesteBiblioteca {

	Biblioteca biblioteca = new Biblioteca();
	BufferedReader in;
	GerenteLivro gl1;
	GerenteUsuario gu1;
	GerenteEmprestimo ge1;
	Aluno a1, a2, a3, a4;
	DadosPessoal d1, d2, d3, d4;
	Endereço e1, e2, e3, e4;
	Livro lv1, lv2, lv3, lv4;

	public void InicializadorDeMultas() {
		gl1 = new GerenteLivro();
		gu1 = new GerenteUsuario();
		ge1 = new GerenteEmprestimo();

		lv1 = new Livro("O profeta", "Mesfsias", "1920", "Aurora2", "1023");
		lv2 = new Livro("O chato", "Messihas", "1930", "Aurora3", "1024");
		lv3 = new Livro("O louco", "Messgias", "1940", "Aurora4", "1025");
		lv4 = new Livro("O mago", "Messias", "1950", "Aurora6", "1026");
		// --
		d1 = new DadosPessoal();
		d1.setCpf("89089089020");
		d1.setIdentidade("1234567");
		d1.setNome("João");
		e1 = new Endereço();
		e1.setBairro("geisel");
		e1.setCidade("JP");
		e1.setEstado("PB");
		e1.setRua("Rua das Jaqueiras");
		a1 = new Aluno(d1, e1, 10644444);
		// --
		d2 = new DadosPessoal();
		d2.setCpf("12312312390");
		d2.setIdentidade("1277567");
		d2.setNome("Jose");
		e2 = new Endereço();
		e2.setBairro("geisel");
		e2.setCidade("JP");
		e2.setEstado("PB");
		e2.setRua("Rua das Jaqueiras");
		a2 = new Aluno(d2, e2, 10654444);
		// --
		d3 = new DadosPessoal();
		d3.setCpf("89089089022");
		d3.setIdentidade("1234667");
		d3.setNome("João");
		e3 = new Endereço();
		e3.setBairro("morimah");
		e3.setCidade("AD");
		e3.setEstado("SE");
		e3.setRua("Rua das Jaqueiras 4234");
		a3 = new Aluno(d3, e3, 10664444);
		// --
		d4 = new DadosPessoal();
		d4.setCpf("89089088820");
		d4.setIdentidade("1234567");
		d4.setNome("Maria");
		e4 = new Endereço();
		e4.setBairro("Cidade OP");
		e4.setCidade("SL");
		e4.setEstado("Ma");
		e4.setRua("Rua das Jaqueiras 2");
		a4 = new Aluno(d4, e4, 10674444);
		// --
		gl1.CadastraLivros(lv1.getIsbn(), lv1);
		gl1.CadastraLivros(lv2.getIsbn(), lv2);
		gl1.CadastraLivros(lv3.getIsbn(), lv3);
		gl1.CadastraLivros(lv4.getIsbn(), lv4);
		gu1.CadastrarAluno(a1, a1.getMatricula());
		gu1.CadastrarAluno(a2, a2.getMatricula());
		gu1.CadastrarAluno(a3, a3.getMatricula());
		gu1.CadastrarAluno(a4, a4.getMatricula());
		// copiando para o gerente de emprestimo
		ge1.setAlunos(gu1.getAlunos());
		ge1.setLivros(gl1.getLivros());
	}

	public void AbreArquivo() throws IOException {
		try {
			in = new BufferedReader(new FileReader(
					"/home/maikon/Documentos/dados.txt"));
			System.out.println(in.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void FechaArquivo() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Endereço CadastrarEndereco() {

		Endereço end = new Endereço();
		end.setRua("Aurora");
		end.setBairro("Centro");
		end.setCidade("Rio Tinto");
		end.setEstado("Paraiba");

		return end;
	}

	public DadosPessoal CadastrarDadosPessoal() {

		DadosPessoal dados = new DadosPessoal();
		dados.setNome("Maikon");
		dados.setCpf("088.237.790-67");
		dados.setIdentidade("783.78343");

		return dados;
	}

	// Aluno

	public Aluno CriarAluno() {

		Endereço end = CadastrarEndereco();
		DadosPessoal dados = CadastrarDadosPessoal();
		Aluno aluno = new Aluno(dados, end, 81211290);

		return aluno;
	}

	// Teste Aluno

	@Test
	public void CadastrarAlunoNovo() {

		Aluno aluno = CriarAluno();
		Assert.assertTrue(biblioteca.getGerenteUsuario().CadastrarAluno(aluno,
				aluno.getMatricula()));

	}

	@Test(expected = BibliotecaException.class)
	public void CadastrarAlunoExistente() {

		Aluno aluno = CriarAluno();
		Aluno aluno2 = CriarAluno();

		biblioteca.getGerenteUsuario().CadastrarAluno(aluno,
				aluno.getMatricula());
		Assert.assertEquals("Aluno Existente", biblioteca.getGerenteUsuario()
				.CadastrarAluno(aluno2, aluno.getMatricula()));

	}

	@Test(expected = BibliotecaException.class)
	public void CadastrarAlunoNulo() {

		Aluno aluno = new Aluno(null, null, 0);
		Assert.assertEquals("Aluno Nulo", biblioteca.getGerenteUsuario()
				.CadastrarAluno(aluno, aluno.getMatricula()));

	}

	@Test
	public void RemoverAlunoexistente() {

		Aluno aluno = CriarAluno();
		biblioteca.getGerenteUsuario().CadastrarAluno(aluno,
				aluno.getMatricula());

		Assert.assertTrue(biblioteca.getGerenteUsuario().RemoverAluno(
				aluno.getMatricula()));
	}

	@Test(expected = BibliotecaException.class)
	public void RemoverUsuarioRemovido() {

		Assert.assertEquals("Usuario não existe", biblioteca
				.getGerenteUsuario().RemoverAluno(12345678));

	}

	@Test(expected = BibliotecaException.class)
	public void RemoverUsuarioNulo() {

		Assert.assertEquals("Usuario não existe", biblioteca
				.getGerenteUsuario().RemoverAluno(12345678));

	}

	@Test(expected = BibliotecaException.class)
	public void CadastrarAlunoComMatriculaMenorOitoDigitos() {
		Aluno aluno = CriarAluno();
		aluno.setMatricula(1234);
		Assert.assertEquals("Matricula Com menos de 8 digitos", biblioteca
				.getGerenteUsuario()
				.CadastrarAluno(aluno, aluno.getMatricula()));
	}

	@Test(expected = BibliotecaException.class)
	public void VerificaDadosPessoalNulo() {

		Aluno aluno = CriarAluno();
		aluno.getDados().setNome(null);

		Assert.assertEquals("Nome nulo", biblioteca.getGerenteUsuario()
				.VerificaDadosPessaolNulos(aluno));

	}

	@Test(expected = BibliotecaException.class)
	public void VerificaEndereçoNulo() {

		Aluno aluno = CriarAluno();
		aluno.getEnd().setRua(null);

		Assert.assertEquals("Rua nula", biblioteca.getGerenteUsuario()
				.VerificaEndereçoNulos(aluno));

	}

	// Funcionario

	public Funcionario CriarFuncionario() {

		Endereço end = CadastrarEndereco();
		DadosPessoal dados = CadastrarDadosPessoal();
		Funcionario funcionario = new Funcionario(dados, end, "Atendente", 800);

		return funcionario;
	}

	@Test
	public void CadastrarFuncionarioNovo() {

		Funcionario funcionario = CriarFuncionario();
		Assert.assertTrue(biblioteca.getGerenteFuncionario()
				.CadastrarFuncionario(funcionario));
	}

	@Test(expected = BibliotecaException.class)
	public void CadastrarFuncionarioExistente() {

		Funcionario funcionario = CriarFuncionario();
		biblioteca.getGerenteFuncionario().CadastrarFuncionario(funcionario);
		Assert.assertEquals("Funcionario Existe", biblioteca
				.getGerenteFuncionario().CadastrarFuncionario(funcionario));

	}

	@Test
	public void PromoverFuncionario() {
		Funcionario funcionario = CriarFuncionario();
		funcionario.setCargo("Gerente");
		Assert.assertEquals("Gerente", funcionario.getCargo());

	}

	@Test
	public void DemitirFuncionario() {
		Funcionario funcionario = CriarFuncionario();
		biblioteca.getGerenteFuncionario().CadastrarFuncionario(funcionario);
		biblioteca.getGerenteFuncionario().DeleteFuncionario(
				funcionario.getDados().getCpf());
	}

	@Test(expected = BibliotecaException.class)
	public void RemoverFuncionarioDemitido() {
		Funcionario funcionario = CriarFuncionario();
		biblioteca.getGerenteFuncionario().CadastrarFuncionario(funcionario);
		biblioteca.getGerenteFuncionario().DeleteFuncionario(
				funcionario.getDados().getCpf());
		Assert.assertEquals(
				"Funcionario não existente",
				biblioteca.getGerenteFuncionario().DeleteFuncionario(
						funcionario.getDados().getCpf()));

	}

	@Test(expected = BibliotecaException.class)
	public void CadastrarFuncionarioCampoObrigatorioNulo() {

		Funcionario funcionario = CriarFuncionario();
		funcionario.getDados().setCpf(null);
		Assert.assertEquals("Campo Obrigatorio nulo", biblioteca
				.getGerenteFuncionario().CadastrarFuncionario(funcionario));
	}

	@Test(expected = BibliotecaException.class)
	public void RemoverFuncionarioNulo() {
		Assert.assertEquals("Não existe funcionario com este cpf", biblioteca
				.getGerenteFuncionario().DeleteFuncionario(null));

	}

	public Livro CadastraLivro() {
		Livro livro = new Livro();
		livro.setTitulo("Python");
		livro.setAutor("João Lima");
		livro.setAutor("2014");
		livro.setEditora("Editora Saraiva");
		livro.setCodigo("454545");

		return livro;
	}

	public Livro CadastraLivro2() {
		Livro livro = new Livro();
		livro.setTitulo("Java");
		livro.setAutor("Antonio Lima");
		livro.setAutor("2011");
		livro.setEditora("Editora Saraiva");
		livro.setCodigo("686868");

		return livro;
	}

	@Test
	public void CadastrarLivroNovo() {
		Livro livro1 = CadastraLivro();
		Livro livro2 = CadastraLivro2();

		biblioteca.getGerenteLivro().CadastraLivros("3457", livro1);
		biblioteca.getGerenteLivro().CadastraLivros("3458", livro2);
	}

	@Test
	public void ConsultarLivro() {
		Livro livro1 = CadastraLivro();

		biblioteca.getGerenteLivro().CadastraLivros("3450", livro1);
		assertTrue(biblioteca.getGerenteLivro().ConsultarLivro("3450"));
	}

	@Test
	public void RemoverLivro() {
		Livro livro1 = CadastraLivro();
		biblioteca.getGerenteLivro().CadastraLivros("3457", livro1);
		assertTrue(biblioteca.getGerenteLivro().RemoverLivro("3457"));
	}

	@Test(expected = BibliotecaException.class)
	public void cadastrarLivroComMesmoRegistro() {
		Livro livro1 = CadastraLivro();
		Livro livro2 = CadastraLivro2();

		biblioteca.getGerenteLivro().CadastraLivros("3457", livro1);
		biblioteca.getGerenteLivro().CadastraLivros("3457", livro2);

	}

	@Test(expected = BibliotecaException.class)
	public void consultarLivroNaoCadastrado() {
		assertTrue(biblioteca.getGerenteLivro().ConsultarLivro("2410"));
	}

	@Test(expected = BibliotecaException.class)
	public void RemoverLivroNovamente() {
		Livro livro1 = CadastraLivro();
		biblioteca.getGerenteLivro().CadastraLivros("3457", livro1);
		assertTrue(biblioteca.getGerenteLivro().RemoverLivro("3457"));
		assertFalse(biblioteca.getGerenteLivro().RemoverLivro("3459"));
	}

	@Test(expected = BibliotecaException.class)
	public void RemoverLivroInexistente() {
		assertTrue(biblioteca.getGerenteLivro().RemoverLivro("5634"));
	}

	@Test(expected = BibliotecaException.class)
	public void cadastrarLivroSemRegistro() {
		Livro livro1 = CadastraLivro();
		biblioteca.getGerenteLivro().CadastraLivros(null, livro1);
	}
	
	@Test
	public void testandoBuscaEmprestimo() {
		InicializadorDeMultas();
		ge1.emprestarLivro(10664444,"1023");
		ge1.buscarEmprestimo(10664444);
		assertTrue(verificaBuscaEmprestimo(a3,ge1));
	}
	
	private boolean verificaBuscaEmprestimo(Aluno a3, GerenteEmprestimo ge1) {
		int temp1=  a3.getMatricula();
		Aluno temp=ge1.buscarAluno(10664444);
		int temp2=temp.getMatricula();
		if(temp1==temp2) {return true;} else
		return false;
	}

	@Test
	public void testandoBuscarAlunoEmEmprestimo() {
		InicializadorDeMultas();
		ge1.emprestarLivro(10644444,"1023");
		assertTrue(a1.equals(ge1.buscarAluno(10644444)));
	}
	@Test
	public void testandoBuscarLivroEmEmprestimo() {
		InicializadorDeMultas();
		Livro temp = ge1.buscarLivro("1024");
		assertTrue(lv2.getIsbn().equals(temp.getIsbn()));
	}
	@Test
	public void testandAplicarMulta(){
		InicializadorDeMultas();
		ge1.emprestarLivro(10644444,"1023");
		double valorMulta=30.50;
		ge1.aplicarMulta(10644444, valorMulta);
		Emprestimo emprestimoTemp = new Emprestimo();
		emprestimoTemp = ge1.buscarEmprestimo(10644444);
		assertTrue(emprestimoTemp.getMulta()==valorMulta);
	}
	@Test
	public void testandAplicarDescontoEmMulta(){
		InicializadorDeMultas();
		ge1.emprestarLivro(10644444,"1023");
		double valorMulta=30.50;
		double valorFinal=10.50;
		ge1.aplicarMulta(10644444, valorMulta);
		ge1.descontoMulta(10644444, 20.00);
		Emprestimo emprestimoTemp = new Emprestimo();
		emprestimoTemp = ge1.buscarEmprestimo(10644444);
		assertTrue(emprestimoTemp.getMulta()==valorFinal);
	}
	
	

}
