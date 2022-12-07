package entities;

public class Aluno {

    // tem: atributos
    private String nome;
    private int idade;
    private double nota1;
    private double nota2;

    // construtor
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // getter and setter
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia(){
        return (nota1 + nota2) / 2.0;
    }

    // faz: métodos
    public double somar(double a, double b) {
        return a + b;
    }
    
    public String calcularFizzBuzz(int number) {
        if(isMultipleOf(number, 3, 5) )
            return "FizzBuzz";

        if(isMultipleOf(number, 3))
            return "Fizz";

        if(isMultipleOf(number, 5))
            return "Buzz";

        return "None";
    }

    public void fazerAniversario(){
        idade++;
    }
    private boolean isMultipleOf(int number, int... divisors) {
        for(int x : divisors){
            if(number%x != 0)
                return false;
        }

        return true;
    }

}
