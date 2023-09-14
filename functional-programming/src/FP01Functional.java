import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12,34,5,6,7,123,556));
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
}