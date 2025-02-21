package org.demo.examples;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        System.out.println("numbers: " + numbers);

        System.out.println("----addListStructured----");
        int sum = addListFunctional(numbers);
        System.out.println(sum);
    }

    private static int sum(int a, int b) {
        //Here 'a' is aggregate, 'b' is next number
        System.out.println("a: " + a + ", b:" + b);
        return a + b;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //Combine them into one result => One value
        //0 and (a,b) -> a + b
        return numbers.stream()
                /*.reduce(0, FP02Functional::sum);*/ // This is by using method reference
                /*.reduce(0, (x, y) -> x + y);*/ // This is another way
                .reduce(0, Integer::sum);
    }

    /*int sum = 0;
    for(Integer number : numbers) {
        sum += number;
    }
    return sum;*/

}
