package org.demo.examples;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class FP05Parallelizing {
    public static void main(String[] args) {
        //Take huge list of numbers and add from 0 to 1000000000
        System.out.println("----------------- Without parallel processing -----------------");
        long startTime = Instant.now().toEpochMilli();
        System.out.println(LongStream.range(0, 1000000000).sum());
        System.out.println("Total time taken: " + (Instant.now().toEpochMilli() - startTime));

        System.out.println("----------------- With parallel processing -----------------");
        long startTime2 = Instant.now().toEpochMilli();
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());
        System.out.println("Total time taken: " + (Instant.now().toEpochMilli() - startTime2));


        //Below code was done using JShell. Keeping here for reference.
        //Modifying lists with replaceAll and removeIf
        printSingleSeparator();
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println("courses: " + courses);
        //Below code was done using JShell. Keeping here for reference.
        //System.out.println(courses.replaceAll(str -> str.toUpperCase()));
        List<String> modifiableCourses = new ArrayList<>(courses);
        modifiableCourses.replaceAll(String::toUpperCase);
        System.out.println("replaceAll toUpperCase: " + modifiableCourses);
        modifiableCourses.removeIf(course -> course.length() < 6);
        System.out.println("removeIf: " + modifiableCourses);
    }

    public static void printSingleSeparator() {
        System.out.println("---------------------------------------------------------------------");
    }
}
