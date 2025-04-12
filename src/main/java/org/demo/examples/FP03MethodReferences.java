package org.demo.examples;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //courses.stream().map(word -> word.toUpperCase()).forEach(System.out::println);
        /*courses.stream()
                .map(word -> word.toUpperCase())
                .forEach(FP03MethodReferences::prnt);*/
        courses.stream()
                .map(String::toUpperCase) //This is instance method reference
                .forEach(FP03MethodReferences::prnt); //This is static method reference

        Supplier<String> supplier = String::new; //This is constructor reference
    }

    public static void prnt(String str) {
        System.out.println(str);
    }
}
