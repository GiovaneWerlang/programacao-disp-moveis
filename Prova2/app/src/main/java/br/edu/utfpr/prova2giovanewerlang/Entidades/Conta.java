package br.edu.utfpr.prova2giovanewerlang.Entidades;

import java.util.Date;

import br.edu.utfpr.prova2giovanewerlang.Enums.TipoConta;

public class Conta {

    private int id;
    private Date data;
    private String descricao;
    private TipoConta tipo;
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
