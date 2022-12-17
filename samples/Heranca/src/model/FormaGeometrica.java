package model;

import model.enums.Cor;

public abstract class FormaGeometrica implements Comparable<FormaGeometrica> {

    // atributos
    private double espessura;
    private Cor cor;

    // constructor

    public FormaGeometrica(double espessura) {
        this.espessura = espessura;
        cor = Cor.INCOLOR;
    }

    public FormaGeometrica(double espessura, Cor cor) {
        this.espessura = espessura;
        this.cor = cor;
    }

    // getter and setter

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    // métodos
    public abstract double area();

    public abstract double comprimento();

    @Override
    public int compareTo(FormaGeometrica other) {
        return Double.compare(this.getEspessura(), other.getEspessura());
    }

    // to string
    @Override
    public String toString() {
        return "FormaGeometrica{" +
                "espessura=" + espessura +
                ", cor=" + cor +
                '}';
    }
}
