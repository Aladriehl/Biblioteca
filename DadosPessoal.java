package com.biblioteca;

public class DadosPessoal {

    private String nome;
    private String cpf;
    private String identidade;

    public void setCpf(String cpf) {
        this.cpf = cpf;

    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", cpf=" + cpf + ", identidade="
                + identidade;
    }

}
