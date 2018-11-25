package br.ufrn.eaj.tads.carroautnomo.Modelo;

import java.util.Objects;

public class Mapeamento {

    private int coluna;
    private int linha;
    private int valor;

    public Mapeamento(int coluna, int linha, int valor) {
        this.coluna = coluna;
        this.linha = linha;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public Mapeamento() {

    }
}
