package org.demo.examples;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviourParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 3, 4, 6, 2, 4, 12, 15);

        System.out.println();
        filterAndPrint(numbers, x -> x % 2 == 0);

        System.out.println();
        filterAndPrint(numbers, x -> x % 2 != 0);

        //Exercise 13
        //Do Behaviour Parameterization for the mapping logic
        System.out.println();
        raisePowerAndPrint(numbers, x -> x * x);

        System.out.println();
        raisePowerAndPrint(numbers, x -> x * x * x);
    }


    // we are passing an argument of this method as a behaviour of the method (even or odd predicate).
    // here predicate is the behaviour of the method which is being passed as an argument.
    // we are passing algorithm(strategy) as an argument!
    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static void raisePowerAndPrint(List<Integer> numbers,
                                           Function<Integer, Integer> mappingFunction) {
        numbers.stream()
                .map(mappingFunction)
                .forEach(System.out::println);
    }


}
