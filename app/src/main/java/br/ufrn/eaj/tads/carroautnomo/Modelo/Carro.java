package br.ufrn.eaj.tads.carroautnomo.Modelo;

import java.util.Objects;

public class Carro {

    private boolean esquerda;
    private boolean direita;
    private boolean frente;
    private boolean parar;

    public Carro(boolean esquerda, boolean direita, boolean frente, boolean parar) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.frente = frente;
        this.parar = parar;
    }

    public Carro(){}

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isFrente() {
        return frente;
    }

    public void setFrente(boolean frente) {
        this.frente = frente;
    }

    public boolean isParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "esquerda=" + esquerda +
                ", direita=" + direita +
                ", frente=" + frente +
                ", parar=" + parar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return esquerda == carro.esquerda &&
                direita == carro.direita &&
                frente == carro.frente &&
                parar == carro.parar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(esquerda, direita, frente, parar);
    }
}
