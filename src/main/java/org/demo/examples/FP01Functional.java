package org.demo.examples;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListFunctional(numbers);
        System.out.println("----------------------------------------");
        printAllEvenNumbersInListFunctional(numbers);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        /*for(Integer number : numbers) {
            System.out.println(number);
        }*/

        //What to do? - In functional programming focus is on explicitly describing what to solve.
        /*numbers.forEach(FP01Functional::print);*/
        numbers.forEach(System.out::println); //method reference
    }

    public static void print(int number) {
        System.out.println(number);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
    }
}
