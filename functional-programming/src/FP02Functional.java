import java.util.Arrays;
import java.util.List;

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
    }
}
