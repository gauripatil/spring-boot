import java.util.List;
import java.util.Optional;

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruitList = List.of("apple", "banana", "orange");
        Optional<String> optional = fruitList.stream().filter(fruit -> fruit.startsWith("b")).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        //OUTPUT
//        Optional[banana]
//        false
//        true
//        banana

        optional = fruitList.stream().filter(fruit -> fruit.startsWith("c")).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get()); // to avoid exception on this line use of Optional is useful

        //OUTPUT
//        Optional.empty
//        true
//        false
//        Exception in thread "main" java.util.NoSuchElementException: No value present
//        at java.base/java.util.Optional.get(Optional.java:143)

    }
}
