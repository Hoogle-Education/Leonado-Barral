import exception.ExpessuraNegativaException;
import model.Circulo;
import model.FormaGeometrica;
import model.Retangulo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<FormaGeometrica> formas = new ArrayList<>();

        try {
            System.out.print("Digite a espessura: ");
            double espessura = sc.nextDouble();

            if(espessura < 0) {
                throw new ExpessuraNegativaException("esspessura incorreta na entrada");
            }
        } catch (ExpessuraNegativaException e) {
            System.err.println(e.getMessage());
        }

        // upcasting - menciona classe filha como classe mãe
        FormaGeometrica forma1 = new Retangulo(1.2, 4);
        FormaGeometrica forma2 = new Circulo(1.6, 3);

        // downcasting - menciona a clase mãe como classe filha
        System.out.println(((Retangulo)forma1).getAltura());

        formas.add(forma1);
        formas.add(forma2);

        Collections.sort(formas);

        System.out.println("------------------------");
        formas.forEach(System.out::println);
    }
}