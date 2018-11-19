package br.ufrn.eaj.tads.carroautnomo.Modelo;

public class Jogo {

    private int linha;
    private int coluna;
    private boolean valor;

    public Jogo(int linha, int coluna, boolean valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    public Jogo() {
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
}
