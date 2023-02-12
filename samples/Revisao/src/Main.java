
//   [x] Use an IDE (e.g. Eclipse) to compile, debug and run code
//   [x] Understand Java syntax, create variables, write conditional statements (e.g. if and switch) and control structures (e.g. for and while loops)
//   [x] Use Java’s data types (e.g. Boolean, Integer, Long, Float, Double, String) and operators (e.g. =, ==, !=, <, >)
//   [x] Create and invoke methods
//   []  Understand the differences between static and non static methods
//   []   Understand how to use collection types (e.g. Array, List, Set, Map, Stack) with generics
//        Understand the differences between compile time and runtime, and between compile time types and runtime types
//        Understand the differences between classes and objects
//        Create classes, instantiate objects, use attributes, methods, constructors and associations
//        Use modifiers to apply information hiding
//        Apply the concepts of encapsulation, polymorphism and inheritance
//        Write abstract classes and interfaces
//        Understand the differences between overriding and overloading
//        Apply simple exception handling techniques (try catch)
//        Understand simple lambda expressions (stream, filter, map, reduce, forEach, collect)
//        Understand simple UML class diagrams

//   Compilada: código -> compilado -> binário
//   Interpretadas: código -> traduz linha a linha
//   Pré-Compilada: Código puro -> pré-compilado(JDK) -> bytecode -> compilação(JVM/JRE) -> executável

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(String c) {
        return switch (c) {
            case "a", "e", "i", "o", "u" -> true;
            default -> false;
        };
    }
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int a = keyboard.nextInt();
        int toIntString = Integer.parseInt("123");
        BigInteger bigInteger = new BigInteger(String.valueOf(a));

        boolean answer = isVowel("y");

        switch (a) {
            case 1 -> System.out.println("foi 1");
            case 2 -> System.out.println("foi 2");
            default -> System.out.println("diferente de 1");
        }
    }
}