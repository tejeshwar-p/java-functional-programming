package org.demo.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {
    public static void main(String[] args) throws IOException {
        printSingleSeparator();
        Files.lines(Paths.get("file.txt"))
                        .forEach(System.out::println);

        printSingleSeparator();
        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        printSingleSeparator();
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        printSingleSeparator();
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }

    public static void printSingleSeparator() {
        System.out.println("---------------------------------------------------------------------");
    }
}
