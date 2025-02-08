package org.demo.examples;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        printAllNumbersInListStructure(numbers);
        System.out.println("----------------------------------------");
        printEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructure(List<Integer> numbers) {
        // How to do? - In structural programming focus is on explicitly describing how to solve.
        for(Integer number : numbers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
