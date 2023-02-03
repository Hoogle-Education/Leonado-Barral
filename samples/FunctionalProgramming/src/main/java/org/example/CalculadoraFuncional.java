package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class CalculadoraFuncional {

    public static void main(String[] args) {
        List<Integer> integersBuffer = new ArrayList<>(List.of(3, 4, 8, 20, 10, 10, 20));
        List<String> operatorBuffer = new ArrayList<>(List.of(".", "+", "-", "+", "*", "/"));

        BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> subtraction = (x, y) -> x-y;
        BinaryOperator<Integer> multiplication = (x, y) -> x*y;
        BinaryOperator<Integer> division = (x, y) -> x/y;

        Function<String, BinaryOperator<Integer>> operatorIdentifier
                = op -> switch (op) {
            case "+" -> sum;
            case "-" -> subtraction;
            case "*", "." -> multiplication;
            case "/" -> division;
            default -> throw new InputMismatchException("invalid operation!");
        };

        int result = integersBuffer.stream().reduce(integersBuffer.remove(0),
                (x, y) -> operatorIdentifier.apply(operatorBuffer.remove(0)).apply(x, y)
        );

        System.out.println(result);
    }


}
