import java.util.Arrays;
import java.util.Optional;

// Generic sınıf tanımı
class GenericClass<T> {
    private T value;

    // Constructor
    public GenericClass(T value) {
        this.value = value;
    }

    // Değeri ekrana yazdıran metod
    public void printValue() {
        System.out.println("Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        // --- 1. Generic Sınıf Kullanımı ---
        System.out.println("Generic Sınıf Kullanımı:");
        GenericClass<Integer> intInstance = new GenericClass<>(42);
        intInstance.printValue();

        GenericClass<String> stringInstance = new GenericClass<>("Merhaba");
        stringInstance.printValue();

        GenericClass<Double> doubleInstance = new GenericClass<>(3.14);
        doubleInstance.printValue();

        System.out.println();

        // --- 2. Dizi ve Bulunacak Öğeyi Alan Metot ---
        System.out.println("Dizi ve Bulunacak Öğeyi Alan Metot:");
        String[] array = {"elma", "armut", "çilek", "muz"};
        String searchElement = "çilek";

        System.out.println(findElement(array, searchElement)); // "çilek"
        System.out.println(findElement(array, "kivi"));        // "-1"

        System.out.println();

        // --- 3. Stream API Kullanımı ---
        System.out.println("Stream API Kullanımı:");
        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer target = 3;

        System.out.println(findWithStream(numbers, target)); // 3
        System.out.println(findWithStream(numbers, 10));    // -1
    }

    // Metot 1: Generic dizi içinde eleman bulma
    public static <T> T findElement(T[] array, T element) {
        return Arrays.stream(array)
                .filter(e -> e.equals(element))
                .findFirst()
                .orElse((T) "-1");
    }

    // Metot 2: Stream API ile eleman bulma
    public static <T> T findWithStream(T[] array, T element) {
        Optional<T> result = Arrays.stream(array)
                .filter(e -> e.equals(element))
                .findFirst();
        return result.orElse((T) Integer.valueOf(-1));
    }
}
