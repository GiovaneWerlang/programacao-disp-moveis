package br.edu.utfpr.usandosqliteopenhelper.Entidade;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int cod;
    private String nome;
    private int idade;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
