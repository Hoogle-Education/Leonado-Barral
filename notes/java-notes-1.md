# OOP - Oriented Object Programming


## Solução procedural

Classe: Molde/Ideia/Modelo
Objeto: Fruto do molde

```java
  int tamanho;
  String[] nomes;
  int[] idades;
  double[] notas;
```

**Problema:** Trocar variáveis, deletar e a ideia das entidades está na responsabilidade do programador.

## Solução Orientada a Objetos

```java
class Aluno {

  // tem: atributos
  String nome;
  int idade;
  double nota1;
  double nota2;

  // faz: métodos
  double media(){
    return (nota1 + nota2) / 2.0;
  }

  double somar(double a, double b) {
    return a + b;
  }

  void fazerAniversario(){
    idade++;
  }

}

public class Program{
  public static void main(String[] args) {
    Aluno joao = new Aluno();

    joao.nome = "Joao da Silva";

    Aluno test = joao;
    int x = 2, y = 3;

    joao.swap(x, y);

    test.nome = "alguma coisa";

    joao.idade = 20;
    joao.fazerAniversario();
    System.out.println(joao.idade);

  }
}
```