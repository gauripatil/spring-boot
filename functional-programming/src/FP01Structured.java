import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructure(List.of(12,34,5,6,7,123,556));
    }

    private static void printAllNumbersInListStructure(List<Integer> integers) {
        for (int number: integers) {
            System.out.println(number);
        }
    }
}