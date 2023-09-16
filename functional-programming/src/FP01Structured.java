import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        System.out.println("Print All Numbers::::");
        printAllNumbersInListStructure(List.of(12,34,5,6,7,123,556));

        System.out.println("Print Even Numbers::::");
        printEvenNumbersInListStructure(List.of(12,34,5,6,7,123,556));
    }

    private static void printAllNumbersInListStructure(List<Integer> integers) {
        for (int number: integers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructure(List<Integer> integers) {
        for (int number: integers) {
            if(number%2==0) {
                System.out.println(number);
            }
        }
    }
}