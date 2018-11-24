package br.ufrn.eaj.tads.carroautnomo.Modelo;

import java.util.Objects;

public class Mapeamento {

    private int coluna;
    private int linha;

    public Mapeamento(int coluna, int linha) {
        this.coluna = coluna;
        this.linha = linha;
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
