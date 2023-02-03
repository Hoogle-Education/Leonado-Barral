package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    // expressão matemática
    // () -> ()
    // () -> { ... }

    // Predicate: (T) -> boolean
    // ex.: filter, anyMatch, allMatch, noneMatch, takeWhile, dropWhile

    // Consumer (T, U) -> void
    // ex.: forEach

    // Function (T) -> (R)
    //ex: map

    // Supplier
    // () -> (T)

    // Bi-function (T, U) -> (R)
    // Integer::sum

    public static boolean isEven(Integer number) {
        return number%2 == 0;
    }

    public static boolean isPrime(Integer number) {
        if(number <= 1) return false;

        for(int i = 2; i < number; i++) {
            if(number%i ==0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));


        Predicate<Integer> isEven = Main::isEven;
        Predicate<Integer> isPrime = Main::isPrime;

        // para todo ... tal que ...


        int soma = integers.stream().reduce(1,Integer::sum);
        int produtorio = integers.stream().reduce(1, (x, y) -> x*y);

        BiFunction<List<Integer>, List<Integer>, Boolean> isAgregated
                = (l1, l2) -> l1.addAll(l2);

//        integers.forEach(e -> {
//            Random random = new Random();
//            int r = random.nextInt();
//            System.out.println(r*e);
//        });

        integers
            .stream()
            .filter(isEven.or(isPrime))
            .forEach(x -> System.out.print(x + ", "));


    }
}