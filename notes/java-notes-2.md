# Herança

```
  FormaGeometrica
    > Quadrado
    > Retangulo
    > Circulo
```

```java
public class FormaGeometrica {

  private double espessura;
  private Cor cor;

  public FormaGeometrica(double espessura) {
    this.espessura = espessura;
    this.cor = Cor.INCOLOR;
  }

  public FormaGeometrica(double espessura, Cor cor) {
    this(espessura);
    this.cor = cor;
  }

  // getter and setter ...

  // métodos
  public double area() {
    return -1;
  }

  public double comprimento() {
    return -1;
  }

}
```

```java
public Retangulo extends FormaGeometrica {

  private double comprimento;
  private double altura;

  public Retangulo(double comprimento, double altura, double espessura){
    super(espessura);
    this.comprimento = comprimento;
    this.altura = altura;
  }

  public Retangulo(double lado, double espessura) {
    this(lado, lado, espessura);
  }

  // getter and setter ...

  @Override
  public double area(){
    return comprimento * altura;
  }

  @Override
  public double comprimento() {
    return 2*(comprimento + altura);
  }
}
```

# Enums

Tipos enumerados, ou seja, uma lista de valores associados a algumas palavras.

```java
public enum Cor {
  INCOLOR,
  AZUL,
  ROSA,
  VERMELHO, 
  AMARELO,
  PRETO,
  CINZA,
  BRANCO
}
```