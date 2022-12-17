package model;

public class Circulo extends FormaGeometrica {

    public static final double PI = 3.14159265;

    private double raio;

    public Circulo(double espessura, double raio) {
        super(espessura);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() throws ArithmeticException {
        return PI*raio*raio;
    }

    @Override
    public double comprimento() throws ArithmeticException {
        return 2*PI*raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                ", " + super.toString() + "} ";
    }
}
