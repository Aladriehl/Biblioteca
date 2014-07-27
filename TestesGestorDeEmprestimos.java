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
	public void InicializadorDeGestorEmprestimo() {
		gestor = new GestorDeEmprestimo();
		livro1 = new Livro();
		livro2 = new Livro("Vidas de Alcione","Valhala", "1998", "FEB", "000-000-34");
		livro3 = new Livro("Conde de Montecristo","Valhala", "1815", "MCO", "000-000-38");
		a = new Aluno();
	}
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testandoEmprestarUmLivroParaAluno() {
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1);
		Assert.assertTrue("Esperado o retorno de 1 livro", verificaSeComtemUmLivro(a, livro1));	
	}
	
	@Test
	public void testandoEmprestarDoisLivrosParaAluno(){
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1, livro2);
		Assert.assertTrue("Esperado o retorno de 2 livros", verificaSeContemDoisLivros(a, livro1, livro2));
	}
	
	@Test
	public void testandoEmprestarTresLivrosParaAluno(){
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1, livro2, livro3);
		Assert.assertTrue("Esperado o retorno de 3 livros", verificaSeContemTresLivros(a, livro1, livro2, livro3));
	}
	
	@Test
	public void testandoDevolverUmLivroParaAluno(){
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1);
		gestor.devolverLivro(a, livro1);
		Assert.assertFalse("Esperado a remoção de um livro",verificaDevolverUmLivro(a, livro1));
	}
	@Test
	public void testandoDevolverDoisLivrosParaAluno(){
		InicializadorDeGestorEmprestimo();
		gestor.emprestarPara(a, livro1, livro2);
		gestor.devolverLivro(a, livro1, livro2);
		Assert.assertFalse(verificaDevolverDoisLivros(a, livro1, livro2));
	}
//	verifica a devolução de um livro
	private boolean verificaDevolverUmLivro(Aluno a, Livro livro2) {
		if(verificaSeComtemUmLivro(a, livro2)==true){
			return true;} else {return false;}
	}
//	verifica a devolucao de dois livros
	private boolean verificaDevolverDoisLivros(Aluno a, Livro livro1, Livro livro2) {
		if((verificaSeComtemUmLivro(a, livro1)==true) && (verificaSeComtemUmLivro(a, livro2)==true)){
			return true;
		} else {return false;}
	}
	
//  verifica emprestar um livro
	private boolean verificaSeComtemUmLivro(Aluno a, Livro livro1) {
		if(livro1.equals(a.contemLivro(livro1))){
			return true;
		} else {
			return false;
		}
	}
//	verifica emprestar dois livros
	private boolean verificaSeContemDoisLivros(Aluno a2, Livro livro1, Livro livro2) {
		if(verificaSeComtemUmLivro(a2, livro1) && verificaSeComtemUmLivro(a2, livro2)){
			return true;
		} else{
			return false;
		}
	}
//	verifica emprestar tres livros
	private boolean verificaSeContemTresLivros(Aluno a3, Livro l1, Livro l2, Livro l3) {
		if (verificaSeComtemUmLivro(a3, l1) && verificaSeContemDoisLivros(a3, l2, l3)){
			return true;
		} else {
			return false;
		}
	}
	
}
