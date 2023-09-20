import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        System.out.println("\nAll Numbers:");
        List<Integer> integers = List.of(12, 34, 5, 6, 7, 123, 556);
        printAllNumbersInListFunctional(integers);

        System.out.println("\nEven Numbers:");
        printEvenNumbersInListFunctional(integers);

        System.out.println("\nEven Numbers Square:");
        printEvenNumbersSquareInListFunctional(integers);

        System.out.println("\nOdd Numbers:");
        printOddNumbersInListFunctional(integers);

        System.out.println("\nCube of Odd Numbers:");
        printCubeOfOddNumbersInListFunctional(integers);

        System.out.println("\nAll Courses : ");
        List<String> courses = List.of("Spring", "Java", "Spring Boot", "Nodejs", "ExpressJs", "React", "Angular", "GCP", "AWS");
        printCoursesList(courses);

        System.out.println("\nCharacters in courses : ");
        printCharactersInCourses(courses);

        System.out.println("\nOnly Spring : ");
        printCoursesListWithSpring(courses);

        System.out.println("\nCourses with at least 4 letters : ");
        printCoursesListWithAtleastFourLetters(courses);


    }

    private static void printCharactersInCourses(List<String> courses) {
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
                .filter(integer -> integer%2==1)
                .map(integer -> integer * integer * integer)
                .forEach(System.out::println);
    }

    private static void printEvenNumbersSquareInListFunctional(List<Integer> integers) {
        integers.stream()
                .filter(integer -> integer%2==0)
                .map(integer -> integer * integer)
                .forEach(System.out::println);
    }

    private static void printCoursesListWithAtleastFourLetters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCoursesListWithSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCoursesList(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }


    private static void printAllNumbersInListFunctional(List<Integer> integers) {
        //[12,34,5,6,7,123,556]
        // Convert number to stream ie
        // 12
        // 34
        // 5
        // 6
        // etc

        // What to do??
        // How to loop the numbers?
        integers.stream()
                .forEach(System.out::println); // Method reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
//                .filter(FP01Functional::isEven)
                .filter(number -> number%2==0) //Lambda expression
                .forEach(System.out::println); // Method reference
    }

    private static boolean isEven(Integer integer) {
        return integer%2==0;
    }

    private static void printOddNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
//                .filter(FP01Functional::isEven)
                .filter(number -> number%2==1) //Lambda expression
                .forEach(System.out::println); // Method reference
    }

}