import entities.Aluno;
import util.DinamicList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program{
    public static void main(String[] args) {
        Aluno joao = new Aluno("Joao da Silva", 20);

        joao.fazerAniversario();

        System.out.println(joao.getNome());
        System.out.println(joao.getIdade());

        System.out.println(joao.calcularFizzBuzz(15));
        System.out.println(joao.calcularFizzBuzz(9));
        System.out.println(joao.calcularFizzBuzz(25));
        System.out.println(joao.calcularFizzBuzz(91));

        System.out.println("------------------------------------");

        DinamicList myList = new DinamicList();

        myList.append(4);
        myList.append(5);
        myList.append(6);
        System.out.println(Arrays.toString(myList.getValues()));

        System.out.println("contains 5?" + myList.contains(5));
        System.out.println(Arrays.toString(myList.getValues()));

        System.out.println("removing 5");
        myList.removeFirst(5);
        System.out.println(Arrays.toString(myList.getValues()));

        System.out.println("contains 5?" + myList.contains(5));
        System.out.println("removing 5");
        myList.removeFirst(5);
        System.out.println(Arrays.toString(myList.getValues()));

        System.out.println(Arrays.toString(myList.getValues()));
    }
}