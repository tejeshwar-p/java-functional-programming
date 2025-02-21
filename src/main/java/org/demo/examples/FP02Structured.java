package org.demo.examples;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        System.out.println("numbers: " + numbers);
        System.out.println("----printAllNumbersInListStructured----");
        printAllNumbersInListStructured(numbers);
        System.out.println("----printEvenNumbersInListStructured----");
        printEvenNumbersInListStructured(numbers);
        System.out.println("----addListStructured----");
        int sum = addListStructured(numbers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
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
