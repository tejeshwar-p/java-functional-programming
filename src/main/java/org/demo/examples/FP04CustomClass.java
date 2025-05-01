package org.demo.examples;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "\n" + "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP04CustomClass {

    public static void printSingleSeparator() {
        System.out.println("-----------------------------------------------------------------");
    }

    public static void printDoubleSeparator() {
        System.out.println("\n==================================================================\n");
    }

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        System.out.println(courses + "\n");

        //allMatch, noneMatch, anyMatch
        Predicate<Course> scoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> scoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> scoreLessThan90Predicate = c -> c.getReviewScore() < 90;

        /*System.out.println(courses.stream().allMatch(scoreGreaterThan90Predicate));
        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 95));*/

        System.out.println("scoreGreaterThan90 allMatch: " + courses.stream().allMatch(scoreGreaterThan90Predicate));
        System.out.println("scoreGreaterThan95 allMatch: " + courses.stream().allMatch(scoreGreaterThan95Predicate));
        System.out.println("scoreGreaterThan95 noneMatch: " + courses.stream().noneMatch(scoreGreaterThan95Predicate));
        System.out.println("scoreLessThan90 noneMatch: " + courses.stream().noneMatch(scoreLessThan90Predicate));
        System.out.println("scoreLessThan90 anyMatch: " + courses.stream().anyMatch(scoreLessThan90Predicate));
        System.out.println("scoreGreaterThan90 anyMatch: " + courses.stream().anyMatch(scoreGreaterThan90Predicate));
        System.out.println("scoreGreaterThan95 anyMatch: " + courses.stream().anyMatch(scoreGreaterThan95Predicate));

        printDoubleSeparator();

        //Sorting
        Comparator<Course> comparingByNoOfStudentsInc = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDec = Comparator.comparing(Course::getNoOfStudents).reversed();
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviewsInc = Comparator
                .comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        System.out.println("SortNoOfStudentsIncreasing: " + courses.stream().sorted(comparingByNoOfStudentsInc).toList());
        printSingleSeparator();
        System.out.println("SortNoOfStudentsDecreasing: " + courses.stream().sorted(comparingByNoOfStudentsDec).toList());
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsIncreasing: " + courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviewsInc).toList());

        //If comparing object's param has primitive values then use specific primitive comparing methods for better performance.
        //It would reduce autoboxing and autounboxing.
        // use comparingInt, comparingLong, comparingDouble etc.

        printDoubleSeparator();

        // limit, skip, takeWhile, dropWhile -----------------------

        System.out.println("SortNoOfStudentsAndNoOfReviewsLIMIT5: "
                + courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviewsInc)
                .limit(5)
                .toList());
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsSKIP3: "
                + courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviewsInc)
                .skip(3)
                .toList());
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsSKIP3LIMIT5: "
                + courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviewsInc)
                .skip(3)
                .limit(5)
                .toList());
        printSingleSeparator();
        System.out.println("Original List: \n" + courses + "\n");
        printSingleSeparator();
        //take all the elements till specified criteria and skip the remaining elements (even if condition satisfies)
        System.out.println("SortNoOfStudentsAndNoOfReviewsTAKEWHILE: "
                + courses.stream()
                .takeWhile(c -> c.getReviewScore() >= 95)
                .toList());
        printSingleSeparator();
        //drop all the elements till specified criteria and take the remaining elements (even if condition satisfies)
        System.out.println("SortNoOfStudentsAndNoOfReviewsDROPWHILE: "
                + courses.stream()
                .dropWhile(c -> c.getReviewScore() >= 95)
                .toList());

        // top, max, min, findFirst, findAny -----------------------

        printDoubleSeparator();
        //max gets the last element of the list. It does not actually know if the element is really max.
        System.out.println("SortNoOfStudentsAndNoOfReviewsMAX: "
                + courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviewsInc));
        //min gets the first element of the list. It does not actually know if the element is really min.
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsMAX: "
                + courses.stream()
                .min(comparingByNoOfStudentsAndNoOfReviewsInc));
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsMINOPTIONALEMPTY: "
                + courses.stream()
                .filter(scoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviewsInc)); //It prints Optional.empty
        printSingleSeparator();
        System.out.println("SortNoOfStudentsAndNoOfReviewsMINOPTIONALNOTEMPTY: "
                + courses.stream()
                .filter(scoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviewsInc)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
        //to handle null, return a default value
        printSingleSeparator();
        System.out.println("scoreLessThan90FINDFIRSTOPTIONALEMPTY: "
                + courses.stream()
                .filter(scoreLessThan90Predicate)
                .findFirst());
        printSingleSeparator();
        System.out.println("scoreGreaterThan95FINDFIRSTOPTIONALNOTEMPTY: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .findFirst());
        printSingleSeparator();
        System.out.println("scoreGreaterThan95FINDANYOPTIONALNOTEMPTY: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .findAny());

        // sum, average, count -----------------------

        printSingleSeparator();
        System.out.println("scoreGreaterThan95FINDANYOPTIONALNOTEMPTY: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .findAny());

        printSingleSeparator();
        System.out.println("scoreGreaterThan95TOTALNOOFSTUDENTS: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        printSingleSeparator();
        System.out.println("scoreGreaterThan95AVERAGENOOFSTUDENTS: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average()); //OptionalDouble[22000.0]

        printSingleSeparator();
        System.out.println("scoreGreaterThan95COUNTNOOFCOURSES: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count());

        printSingleSeparator();
        System.out.println("scoreGreaterThan95MAXNOOFSTUDENTSOFCOURSE: "
                + courses.stream()
                .filter(scoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .max()); //OptionalInt[25000]

        // groupingBy, maxBy, mapping -----------------------

        printSingleSeparator();
        System.out.println("groupingBy courseCategory: \n"
                + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        printSingleSeparator();
        System.out.println("groupingBy courseCategory and counting for each category: \n"
                + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        printSingleSeparator();
        System.out.println("groupingBy courseCategory and highest review score for each category: \n"
                + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        printSingleSeparator();
        System.out.println("groupingBy courseCategory and only get course names for each category: \n"
                + courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));

        //Below code was done using JShell. Keeping here for reference.
        printSingleSeparator();
        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count());

        //Below code was done using JShell. Keeping here for reference.
        printSingleSeparator();
        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum));
        System.out.println("Type: " + Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
        // In streams all the integers are wrapped.
        // Each time we reduce operation boxing and unboxing operation would happen which is not efficient
        // To overcome this we have to use Arrays.stream()

        //Below code was done using JShell. Keeping here for reference.
        printSingleSeparator();
        int[] numberArray = {12, 9, 1, 4, 6, 2, 4, 12, 15};
        System.out.println(Arrays.stream(numberArray).sum());
        System.out.println(Arrays.stream(numberArray).average());
        System.out.println(Arrays.stream(numberArray).min());
        System.out.println(Arrays.stream(numberArray).max());
        System.out.println("Type: " + Arrays.stream(numberArray));
        // Here reference is of type IntPipeline - stream contains primitive integer values.

        //Below code was done using JShell. Keeping here for reference.
        printSingleSeparator();
        // we can use IntStream to create a primitive sequence of integers.
        System.out.println("Type: " + IntStream.range(1, 10));
        System.out.print("IntStream range: ");
        IntStream.range(1, 10).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("IntStream range sum: " + IntStream.range(1, 10).sum()); // 10 is exclusive.
        System.out.println("IntStream rangeClosed Sum: " + IntStream.rangeClosed(1, 10).sum()); // 10 is inclusive.
        System.out.print("IntStream iterate start with 1, increment by 2: ");
        IntStream.iterate(1, e -> e + 2).limit(10).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("IntStream iterate limit sum: " + IntStream.iterate(1, e -> e + 2).limit(10).sum());
        System.out.print("IntStream iterate start with 2, increment by 2: ");
        IntStream.iterate(2, e -> e + 2).limit(10).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.print("IntStream iterate start with 2, power by 2: ");
        IntStream.iterate(2, e -> e * 2).limit(10).forEach(e -> System.out.print(e + " "));
        System.out.println();
        //IntStream.iterate(2, e -> e * 2).limit(10).collect(Collectors.toList());
        // We cannot directly convert to list it would throw error. We have to do box operation
        System.out.print("IntStream iterate start with 2, power by 2 and convert to list using boxed operation: ");
        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).boxed().toList());


        //Below code was done using JShell. Keeping here for reference.
        printSingleSeparator();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println("Using IntStream: " + IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
        //result is zero because result exceeds limit of Integer.MAX_VALUE
        // we cannot also use LongValue because it would exceed.
        // So we have to use BigInteger
        System.out.println("Using LongStream: " + LongStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
        System.out.println("Using LongStream: " + LongStream.rangeClosed(1, 20).reduce(1, (x, y) -> x * y));
        //using BigInteger
        System.out.print("Using BigInteger with LongStream: ");
        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));


        //Below code was done using JShell. Keeping here for reference.
        //Creating streams using Stream of method and for Arrays
        printSingleSeparator();
        List<Integer> numberList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("Type of numberList.stream(): " + numberList.stream()); //ReferencePipeline
        System.out.println("Count with Stream.of(): " + Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count());
        System.out.println("Reduce with Stream.of(): " + Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum));
        System.out.println("Type of Stream.of(): " + Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15)); //ReferencePipeline
        int[] numberArray2 = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        System.out.println("Type of Arrays.stream(numberArray2): " + Arrays.stream(numberArray2)); //IntPipeline
        //ReferencePipeline is for wrapper classes and IntPipeline is for primitive arrays
        //We can do operations directly with IntPipeline.
        System.out.println("Sum with IntPipeline: " + Arrays.stream(numberArray2).sum());
        System.out.println("Average with IntPipeline: " + Arrays.stream(numberArray2).average());
        System.out.println("Min with IntPipeline: " + Arrays.stream(numberArray2).min());
        System.out.println("Max with IntPipeline: " + Arrays.stream(numberArray2).max());

        //Below code was done using JShell. Keeping here for reference.
        //Joining Strings with joining and Playing with flatMap
        printSingleSeparator();
        List<String> coursesList2 = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println("coursesList2: " + coursesList2);
        System.out.println("Using Collectors.joining(): " + coursesList2.stream().collect(Collectors.joining(", ")));

        System.out.println(Arrays.asList("Spring".split("")));
        System.out.println("Split gives string array" + coursesList2.stream()
                .map(course -> course.split("")).toList()); //This will not give individual characters like String.split
        System.out.println("Using flatmap without distinct: " + coursesList2.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream).toList());
        System.out.println("Using flatmap with distinct: " + coursesList2.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream).distinct().toList());
        List<String> coursesList3 = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println();
        System.out.println("Using flatmap to join each element in courseList3 with courseList2: "
                + coursesList2.stream()
                .flatMap(course2 -> coursesList3.stream().map(course3 -> List.of(course2, course3)))
                .toList());
        System.out.println();
        System.out.println("Using flatmap to join each element in courseList3 with courseList2 and filter out same combination courses: "
                + coursesList2.stream()
                .flatMap(course2 -> coursesList3.stream().map(course3 -> List.of(course2, course3)).filter(list -> !list.get(0).equals(list.get(1))))
                .toList());
        System.out.println();
        //Now find elements with same length
        System.out.println("Using flatmap to join each element in courseList3 with courseList2, " +
                "filter out courses with different course name lengths" +
                "and filter out same name combination courses: "
                + coursesList2.stream()
                .flatMap(course2 -> coursesList3.stream()
                        .filter(course3 -> course3.length() == course2.length())
                        .map(course3 -> List.of(course2, course3))
                        .filter(list -> !list.get(0).equals(list.get(1))))
                .toList());

        //Higher order functions
        //A higher order function is a function which returns a function.
        printSingleSeparator();
        System.out.println("Higher order functions: ");
        System.out.println("A higher order function is a function which returns a function.");
        Predicate<Course> scoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> scoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);
        System.out.println("Predicate<Course> scoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);\n" +
                "Predicate<Course> scoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);\n" +
                "private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {\n" +
                "        return course -> course.getReviewScore() > cutoffReviewScore;\n" +
                "}");

        printSingleSeparator();
        //Below code was done using JShell. Keeping here for reference.
        //It is easier to write performant code with functional programming.
        System.out.println("It is easier to write performant code with functional programming.");
        System.out.println("Filter courses having length > 11, find the first course and print it: ");
        coursesList3.stream().filter(course3 -> course3.length() >11)
                .map(String::toUpperCase).findFirst().ifPresent(System.out::println);
        System.out.println("Use peek(), filter courses having length > 11, find the first course and print it: ");
        coursesList3.stream()
                .peek(System.out::println)
                .filter(course3 -> course3.length() >11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst().ifPresent(System.out::println);
        System.out.println("It is because once the first element is found the other operations are not performed.\n" +
                "Hence, streams are efficient. Writing performant code is easier.\n" +
                "In java all the intermediate operations return stream().\n" +
                "All the intermediate operations are lazy. All the intermediate operations are\n" +
                "executed during the terminal operation.");
        //Here the output will be -
        /*Spring
        Spring Boot
        API
        Microservices
        MICROSERVICES
        MICROSERVICES*/
        //It is because once the first element is found the other operations are not performed.
        //Hence, streams are efficient. Writing performant code is easier.
        //In java all the intermediate operations return stream().
        //All the intermediate operations are lazy. All the intermediate operations are
        //executed during the terminal operation.
    }

    //This is called a higher order function. It returns another function as a return value.
    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }


}
