package org.demo.examples;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
                "Docker", "Kubernetes");
        System.out.println("numbers: " + numbers);
        System.out.println("----printAllNumbersInListFunctional----");
        printAllNumbersInListFunctional(numbers);
        System.out.println("----printAllEvenNumbersInListFunctional----");
        printAllEvenNumbersInListFunctional(numbers);
        System.out.println("----printAllOddNumbersInListFunctional----");
        printAllOddNumbersInListFunctional(numbers);
        System.out.println("----printAllSquaresOfEvenNumbersInListFunctional----");
        printAllSquaresOfEvenNumbersInListFunctional(numbers);
        System.out.println("----printAllCubesOfOddNumbersInListFunctional----");
        printAllCubesOfOddNumbersInListFunctional(numbers);
        System.out.println();
        System.out.println("courses: " + courses);
        System.out.println("----printAllCoursesInListFunctional----");
        printAllCoursesInListFunctional(courses);
        System.out.println("----printCoursesContainingSpringInListFunctional----");
        printCoursesContainingSpringInListFunctional(courses);
        System.out.println("----printCoursesWithAtLeast4LengthInListFunctional----");
        printCoursesWithAtLeast4LengthInListFunctional(courses);
        System.out.println("----printCharactersInCourseNameInListFunctional----");
        printCharactersInCourseNameInListFunctional(courses);
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
        numbers.stream()
                //.filter(FP01Functional::isEven) //Method reference
                .filter(number -> number % 2 == 0) //Lambda
                .forEach(System.out::println);
    }

    private static void printAllOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printAllSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number) //Mapping
                .forEach(System.out::println);
    }

    private static void printAllCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number) //Mapping
                .forEach(System.out::println);
    }



    private static void printAllCoursesInListFunctional(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    private static void printCoursesContainingSpringInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCoursesWithAtLeast4LengthInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCharactersInCourseNameInListFunctional(List<String> courses) {
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }
}
