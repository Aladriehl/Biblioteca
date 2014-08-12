package com.biblioteca;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.tools.FileObject;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteBiblioteca {

    Biblioteca biblioteca = new Biblioteca();
    BufferedReader in;

    public void AbreArquivo() throws IOException {
        try {
            in = new BufferedReader(new FileReader("/home/maikon/Documentos/dados.txt"));
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

    public Endereco CadastrarEndereco() {

        Endereco end = new Endereco();
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

        Endereco end = CadastrarEndereco();
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
                .VerificaEnderecoNulos(aluno));

    }

	// Funcionario
    public Funcionario CriarFuncionario() {

        Endereco end = CadastrarEndereco();
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
        Assert.assertEquals("Funcionario Existe", biblioteca.getGerenteFuncionario().CadastrarFuncionario(funcionario));

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
        biblioteca.getGerenteFuncionario().DeleteFuncionario(funcionario.getDados().getCpf());
        Assert.assertEquals("Funcionario não existente", biblioteca.getGerenteFuncionario().DeleteFuncionario(funcionario.getDados().getCpf()));

    }

    @Test(expected = BibliotecaException.class)
    public void CadastrarFuncionarioCampoObrigatorioNulo() {

        Funcionario funcionario = CriarFuncionario();
        funcionario.getDados().setCpf(null);
        Assert.assertEquals("Campo Obrigatorio nulo", biblioteca.getGerenteFuncionario().CadastrarFuncionario(funcionario));
    }

    @Test(expected = BibliotecaException.class)
    public void RemoverFuncionarioNulo() {
        Assert.assertEquals("Não existe funcionario com este cpf", biblioteca.getGerenteFuncionario().DeleteFuncionario(null));

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

}
