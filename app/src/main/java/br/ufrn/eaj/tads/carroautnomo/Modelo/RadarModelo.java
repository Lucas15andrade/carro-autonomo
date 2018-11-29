package br.ufrn.eaj.tads.carroautnomo.Modelo;

public class RadarModelo {

    int angulo;

    public RadarModelo(int distancia) {
        this.angulo = distancia;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public RadarModelo() {
    }
}
