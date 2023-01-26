package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static boolean isEven(Integer number) {
        return number%2 == 0;
    }

    public static void log(){

    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        Predicate<Integer> isEvenRef = Main::isEven;
        // para todo ... tal que ...


        integers
            .stream()
            .filter(x -> x % 2 == 0)
            .forEach(x -> System.out.print(x + ", "));

        System.out.println();
        integers.stream().filter(x -> x%2==0).toList().forEach(x -> System.out.print(x + ", "));

    }
}