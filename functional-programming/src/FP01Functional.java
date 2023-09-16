import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        System.out.println("All Numbers:");
        List<Integer> integers = List.of(12, 34, 5, 6, 7, 123, 556);
        printAllNumbersInListFunctional(integers);

        System.out.println("Even Numbers:");
        printEvenNumbersInListFunctional(integers);
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
                .filter(FP01Functional::isEven)
                .forEach(System.out::println); // Method reference
    }

    private static boolean isEven(Integer integer) {
        return integer%2==0;
    }
}