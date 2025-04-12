package org.demo.examples;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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

        // limit, skip, takeWhile, dropWhile
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

        //top, max, min, findFirst, findAny
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

        //sum, average, count
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

    }

    public static void printSingleSeparator() {
        System.out.println("-----------------------------------------------------------------");
    }

    public static void printDoubleSeparator() {
        System.out.println("\n==================================================================\n");
    }

}
