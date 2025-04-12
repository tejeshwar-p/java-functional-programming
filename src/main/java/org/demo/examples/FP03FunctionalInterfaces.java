package org.demo.examples;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    /*
      boolean isEven(int x) {
        return x % 2 == 0;
      }

      int square(int x) {
        return x * x;
      }
     */

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 3, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        //Internally compiler does this
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> squareFunction = x -> x * x;

        //Internally compiler does this
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> sysoutConsumer = System.out::println;

        //Internally compiler does this
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {

            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                //.filter(isEvenPredicate)
                .filter(isEvenPredicate2)
                //.map(squareFunction)
                .map(squareFunction2)
                //.forEach(sysoutConsumer);
                .forEach(sysoutConsumer2);

        System.out.println();

        //Exercise -
        //Find Functional Interface behind the second argument of reduce method.
        //Create an implementation for the Functional Interface.

        BinaryOperator<Integer> binaryOperator = Integer::sum;

        BinaryOperator<Integer> binaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

        int sum = numbers.stream()
                //.reduce(0, Integer::sum);
                //.reduce(0, binaryOperator);
                .reduce(0, binaryOperator2);
        System.out.println(sum);
    }
    // apply, accept, test method of the functional interface are called function descriptors
}
