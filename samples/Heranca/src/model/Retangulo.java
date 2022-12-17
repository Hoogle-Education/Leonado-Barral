package model;

public class Retangulo extends FormaGeometrica{

    private double comprimento;
    private double altura;

    public Retangulo(double espessura, double comprimento, double altura) {
        super(espessura);
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public Retangulo(double espessura, double lado) {
        this(espessura, lado, lado);
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return comprimento * altura;
    }

    @Override
    public double comprimento() {
        return 2*(comprimento + altura);
    }


    @Override
    public String toString() {
        return "Retangulo{" +
                "comprimento=" + comprimento +
                ", altura=" + altura +
                ", " + super.toString() + "} ";
    }
}
