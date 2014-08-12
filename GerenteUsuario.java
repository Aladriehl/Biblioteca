package com.biblioteca;

import java.util.*;

public class GerenteUsuario {

    private Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

    public boolean CadastrarAluno(Aluno aluno, int identificacao) {

        if (alunos.get(identificacao) != null) {
            throw new BibliotecaException("Aluno Existente");
        }

        if (aluno == null) {
            throw new BibliotecaException("Aluno Nulo");
        }

        if (identificacao < 10000000) {
            throw new BibliotecaException("Matricula Com menos de 8 digitos");
        }

        alunos.put(identificacao, aluno);
        return true;

    }

    public Map<Integer, Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Map<Integer, Aluno> alunos) {
        this.alunos = alunos;
    }

    public boolean VerificaAluno(Aluno aluno) {

        if (getAlunos().get(aluno.getDados().getNome()).toString() == null) {
            throw new BibliotecaException("Usuario nulo");
        }

        return true;

    }

    public boolean RemoverAluno(int identificacao) {

        if (getAlunos().get(identificacao) == null) {
            throw new BibliotecaException("Usuario não existe");
        }

        getAlunos().remove(identificacao);
        return true;

    }

    public boolean VerificaDadosPessaolNulos(Aluno aluno) {

        String nome = aluno.getDados().getNome();
        String identidade = aluno.getDados().getIdentidade();
        String cpf = aluno.getDados().getCpf();

        if (nome == null) {
            throw new BibliotecaException("Nome nulo");
        }

        if (identidade == null) {
            throw new BibliotecaException("Idantidade nulo");
        }

        if (cpf == null) {
            throw new BibliotecaException("Cpf nulo");
        }

        return true;
    }

    public boolean VerificaEnderecoNulos(Aluno aluno) {

        String rua = aluno.getEnd().getRua();
        String bairro = aluno.getEnd().getBairro();
        String cidade = aluno.getEnd().getCidade();
        String estado = aluno.getEnd().getEstado();

        if (rua == null) {
            throw new BibliotecaException("Rua nula");
        }

        if (bairro == null) {
            throw new BibliotecaException("Bairro nulo");
        }

        if (cidade == null) {
            throw new BibliotecaException("Cidade nulo");
        }

        if (estado == null) {
            throw new BibliotecaException("Estado nulo");
        }

        return true;
    }

    public boolean MudarChaveAluno(Aluno aluno, String chave) {

        getAlunos().get(aluno.getMatricula());

        return true;
    }

}
