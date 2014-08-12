package com.biblioteca;

import java.util.Calendar;
import java.util.Date;

public class Livro {

    private String titulo;
    private String autor;
    private String ano;
    private String editora;
    private String isbn;
    private String codigo;

    private boolean Disponivel = true;
    /*adicionei esses trÊs atributos pra o calculo da multa
     * e pra verificar quantos dias o livro tá emprestado
     * e pra caso queiram adicionar a data de cadastro do livro
     * na biblioteca.
     * */
    private Date dataDeDevolucao;
    private Date dataDeEmprestimo;
    private Date dataDeCadastroDoLivroNaBiblioteca;

    /**/
    /*construtor padrão*/
    public Livro() {
        setTitulo("Titulo padrão");
        setAutor("Autor padrão");
        setAnoDePublicacao("Ano de publicação");
        setEditora("Editora padrão");
        setIsbn("000-000-0");
        setDisponivel(false);
    }

    /*construtor passando os valores*/
    public Livro(String titulo, String autor, String ano, String editora, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setAnoDePublicacao(ano);
        setEditora(editora);
        setIsbn(isbn);
        setDisponivel(true);
    }
    /*metodos get e sets*/

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

    public boolean isDisponivel() {
        return Disponivel;
    }

    public void setDisponivel(boolean estaDisponivel) {
        this.Disponivel = estaDisponivel;
    }

    public String getAnoDePublicacao() {
        return ano;
    }

    public void setAnoDePublicacao(String ano) {
        this.ano = ano;
    }

    private Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    private void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    private Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    private void setDataDeEmprestimo(Date dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    private Date getDataDeCadastroDoLivroNaBiblioteca() {
        return dataDeCadastroDoLivroNaBiblioteca;
    }

    private void setDataDeCadastroDoLivroNaBiblioteca(
            Date dataDeCadastroDoLivroNaBiblioteca) {
        this.dataDeCadastroDoLivroNaBiblioteca = dataDeCadastroDoLivroNaBiblioteca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor
                + ", anoDePublicacao=" + ano + ", editora="
                + editora + ", isbn=" + isbn + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (Disponivel ? 1231 : 1237);
        result = prime * result
                + ((ano == null) ? 0 : ano.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((editora == null) ? 0 : editora.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Livro other = (Livro) obj;
        if (Disponivel != other.Disponivel) {
            return false;
        }
        if (ano == null) {
            if (other.ano != null) {
                return false;
            }
        } else if (!ano.equals(other.ano)) {
            return false;
        }
        if (autor == null) {
            if (other.autor != null) {
                return false;
            }
        } else if (!autor.equals(other.autor)) {
            return false;
        }
        if (editora == null) {
            if (other.editora != null) {
                return false;
            }
        } else if (!editora.equals(other.editora)) {
            return false;
        }
        if (isbn == null) {
            if (other.isbn != null) {
                return false;
            }
        } else if (!isbn.equals(other.isbn)) {
            return false;
        }
        if (titulo == null) {
            if (other.titulo != null) {
                return false;
            }
        } else if (!titulo.equals(other.titulo)) {
            return false;
        }
        return true;
    }

}
