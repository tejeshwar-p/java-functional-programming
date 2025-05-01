package org.demo.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 15, 11);
        System.out.println("numbers: " + numbers);

        System.out.println("----addListFunctional----");
        int sum = addListFunctional(numbers);
        System.out.println(sum);

        System.out.println("----getOnlyXValueFunctional----");
        int onlyXValue = getOnlyXValueFunctional(numbers);
        System.out.println(onlyXValue);

        System.out.println("----getOnlyYValueFunctional----");
        int onlyYValue = getOnlyYValueFunctional(numbers);
        System.out.println(onlyYValue);

        System.out.println("----getMaximumPositiveValueFunctional----");
        int maximumPositiveValue = getMaximumPositiveValueFunctional(numbers);
        System.out.println(maximumPositiveValue);

        System.out.println("----getMaximumValueFunctional----");
        int maximumValue = getMaximumValueFunctional(numbers);
        System.out.println(maximumValue);

        System.out.println("----getMininumValueFunctional----");
        int minimumValue = getMininumValueFunctional(numbers);
        System.out.println(minimumValue);

        System.out.println("----getSumOfSquaresFunctional----");
        int sumOfSquares = getSumOfSquaresFunctional(numbers);
        System.out.println(sumOfSquares);

        System.out.println("----getSumOfCubesFunctional----");
        int sumOfCubes = getSumOfCubesFunctional(numbers);
        System.out.println(sumOfCubes);

        System.out.println("----getSumOfOddNumbersFunctional----");
        int sumOfOddNumbers = getSumOfOddNumbersFunctional(numbers);
        System.out.println(sumOfOddNumbers);

        System.out.println("----printDistinctNumbers----");
        printDistinctNumbers(numbers);

        System.out.println("----printSortedNumbers----");
        printSortedNumbers(numbers);

        System.out.println("----printDistinctSortedNumbers----");
        printDistinctSortedNumbers(numbers);

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println();
        System.out.println("courses: " + courses);
        System.out.println("----printSortedCourses----");
        printSortedCourses(courses);

        System.out.println("----printNaturalOrderSortedCourses----");
        printNaturalOrderSortedCourses(courses);

        System.out.println("----printReverseOrderSortedCourses----");
        printReverseOrderSortedCourses(courses);

        System.out.println("----printLengthOrderSortedCourses----");
        printLengthOrderSortedCourses(courses);

        System.out.println("----getDoubledNumbersList----");
        System.out.println(getDoubledNumbersList(numbers));

        System.out.println("----getSquaredNumbersList----");
        System.out.println(getSquaredNumbersList(numbers));

        System.out.println("----getOddNumbersFromNumbersList----");
        System.out.println(getOddNumbersFromNumbersList(numbers));

        System.out.println("----getCourseLengthFromCoursesList----");
        System.out.println(courses);
        System.out.println(getCourseLengthFromCoursesList(courses));

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

    //Below code was done using JShell. Keeping here for reference.
    private static int getOnlyXValueFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getOnlyYValueFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getMaximumPositiveValueFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x > y ? x : y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getMaximumValueFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getMininumValueFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x < y ? x : y );
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getSumOfSquaresFunctional(List<Integer> numbers) {
        return numbers.stream().map(no -> no*no)
                .reduce(0, (x, y) -> x + y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getSumOfCubesFunctional(List<Integer> numbers){
        return numbers.stream().map(no -> no * no * no)
                .reduce(0,(x,y)-> x + y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static int getSumOfOddNumbersFunctional(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0)
                .reduce(0, (x, y) -> x + y);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printDistinctNumbers(List<Integer> numbers) {
        numbers.stream().distinct().forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printSortedNumbers(List<Integer> numbers) {
        numbers.stream().sorted().forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printDistinctSortedNumbers(List<Integer> numbers) {
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printSortedCourses(List<String> courses) {
        courses.stream().sorted().forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printNaturalOrderSortedCourses(List<String> courses) {
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printReverseOrderSortedCourses(List<String> courses) {
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //Below code was done using JShell. Keeping here for reference.
    private static void printLengthOrderSortedCourses(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }

    private static List<Integer> getDoubledNumbersList(List<Integer> numbers) {
        return numbers.stream().map(number -> number * 2).toList();
    }

    private static List<Integer> getSquaredNumbersList(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number).toList();
    }

    private static List<Integer> getOddNumbersFromNumbersList(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).toList();
    }

    private static List<Integer> getCourseLengthFromCoursesList(List<String> courses) {
        return courses.stream().map(course -> course.length()).toList();
    }

}
