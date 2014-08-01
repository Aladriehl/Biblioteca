import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class TestesGestorDeEmprestimos {
	GestorDeEmprestimo gestor;
	Livro livro1;
	Livro livro2;
	Livro livro3;
	Aluno a;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testandoEmprestarAteTresParaAluno() {
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1);
		Assert.assertTrue("Esperado o retorno de 1 livro", verificaSeComtemUmLivro(a, livro1));
		gestor.emprestarPara(a, livro1, livro2);
		Assert.assertTrue("Esperado o retorno de 2 livros", verificaSeContemDoisLivros(a, livro1, livro2));
		gestor.emprestarPara(a, livro1, livro2, livro3);
		Assert.assertTrue("Esperado o retorno de 3 livros", verificaSeContemTresLivros(a, livro1, livro2, livro3));
	}	
	@Test
	public void testandoDevolverLivro(){
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1);
		gestor.devolverLivro(a, livro1);
		Assert.assertFalse("Esperado que o livro fosse devolvido", verificaDevolucao(a,livro1));
	}	
	@Test
	public void testandoAplicarMulta(){
		InicializadorDeGestorEmprestimo();
		double valorDaMulta = 20.5;
		gestor.aplicarMulta(a,valorDaMulta);
		Assert.assertTrue("esperava o retorno de 20.50 como multa", verificaMultaAplicada(a));
	}
	
	@Test
	public void testandoRemoverMulta(){
		InicializadorDeGestorEmprestimo();
		double valorDaMulta = 20.5;
		gestor.removerMulta(a);
		Assert.assertTrue("esperava o retorno de 0.0 como multa", verificaMultaRemovida(a));
	}
	
	@Test
	public void testandoAplicarDescontoNaMulta(){
		InicializadorDeGestorEmprestimo();
		double valorDaMulta = 20.5;
		gestor.aplicarMulta(a,valorDaMulta);
		gestor.descontarValorDaMulta(a, 10.50);
		Assert.assertTrue("esperado 10 reais com a aplicacao do desconto", verificaAplicacaoDesconto(a));
	}
	
	private boolean verificaAplicacaoDesconto(Aluno a) {
		if (a.verificaTemMulta()==true && a.getMulta()==10.0) {
			return true;
		} else {return false;}
	}

	/*Verifica se tem multa é igual false e se tá retornando o valor da multa como 0.0*/
	private boolean verificaMultaRemovida(Aluno a) {
		if(a.verificaTemMulta()==false && a.getMulta()==0.0){
			return true;
		} else {
			return false;
		}
	}

	/*Verifica se o valor da multa e 20,50 reais*/
	private boolean verificaMultaAplicada(Aluno a) {
		if((a.getMulta()==20.5)){
			return  true;
		}
		else{return false;}
	}
	/*verifica se o livro quando se pede*/
	private boolean verificaDevolucao(Aluno a, Livro livro1) {
		if (verificaSeComtemUmLivro(a, livro1)) {
			return true;
		} else {return false;}
		
	}

	/*Verifica emprestar um livro */
	private boolean verificaSeComtemUmLivro(Aluno a, Livro livro1) {
		if(livro1.equals(a.contemLivro(livro1))){
			return true;
		} else {
			return false;
		}
	}
	/*Verifica emprestar dois livros*/
	private boolean verificaSeContemDoisLivros(Aluno a2, Livro livro1, Livro livro2) {
		if(verificaSeComtemUmLivro(a2, livro1) && verificaSeComtemUmLivro(a2, livro2)){
			return true;
		} else{
			return false;
		}
	}
	/*Verifica emprestar tres livros*/
	private boolean verificaSeContemTresLivros(Aluno a3, Livro l1, Livro l2, Livro l3) {
		if (verificaSeComtemUmLivro(a3, l1) && verificaSeContemDoisLivros(a3, l2, l3)){
			return true;
		} else {
			return false;
		}
	}
	/*Inicializador para os testes*/
	public void InicializadorDeGestorEmprestimo() {
		gestor = new GestorDeEmprestimo();
		livro1 = new Livro("O gato Preto","CM Pocket", "1688", "HOL", "000-000-32");
		livro2 = new Livro("Vidas de Alcione","Valhala", "1998", "FEB", "000-000-34");
		livro3 = new Livro("Conde de Montecristo","Valhala", "1815", "MCO", "000-000-38");
		a = new Aluno();
	}
}
