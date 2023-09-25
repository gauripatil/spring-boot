import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FP02Functional {
    public static void main(String[] args) {

        // EXAMPLE 1: Filter and Print Elements
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // Using stream to filter and print words starting with 'c'
        words.stream()
                .filter(word -> word.startsWith("c"))
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


//        EXAMPLE 2: Map and Reduce
        // Using stream to double each number and then calculate the sum
        int sum = numbers.stream()
                .map(num -> num * 2)
                .reduce(0, Integer::sum);
        System.out.println("Sum of doubled numbers: " + sum);


        // EXAMPLE 3 - SORTING
        List<String> fruits = Arrays.asList("banana", "apple", "cherry", "date", "elderberry");

        // Using stream to sort fruits and print them
        fruits.stream()
                .sorted()
                .forEach(System.out::println);


        List.of("hello", "world")
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

// Output:
// HELLO
// WORLD


        Predicate<Long> isEven = (value) -> value % 2L == 0;
        List.of(1L, 2L, 3L, 5L, 8L, 13L)
                .stream()
                .filter(isEven)
                .forEach(System.out::println);

// Output:
// 2
// 8

        List.of(1L, 2L, 3L, 5L, 8L, 13L)
                .stream()
                .filter(Predicate.not(value -> value % 2L == 0))
                .forEach(System.out::println);

// Output:
// 1
// 3
// 5
// 13

        // TAKE WHILE
        List.of(1L, 5L, 7L, 10L, 11L, 12L)
                .stream()
                .takeWhile(value -> value % 2 != 0)
                .forEach(System.out::println);

// Output:
// 1
// 5
// 7


// DROP WHILE
        List.of(1L, 5L, 7L, 10L, 11L, 12L)
                .stream()
                .dropWhile(value -> value % 2 != 0)
                .forEach(System.out::println);

// Output:
// 10
// 11
// 12


    }
}
