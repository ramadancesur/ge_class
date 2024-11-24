import java.util.Arrays;

class Main {

    // 1. Generic sınıf tanımı
    public static class GenericClass<T> {
        private T value;

        // Constructor
        public GenericClass(T value) {
            this.value = value;
        }

        // Generic alanı yazdıran metot
        public void printValue() {
            System.out.println("Value: " + value);
        }
    }

    // 2. Öğeyi bulan veya -1 dönen metot (Stream API kullanımı)
    public static <T> T findElement(T[] array, T element) {
        return Arrays.stream(array)
                .filter(e -> e.equals(element))
                .findFirst()
                .orElse((T) Integer.valueOf(-1)); // Eğer bulunamazsa -1 döner
    }

    // Main metot
    public static void main(String[] args) {
        // 1. Generic sınıfın test edilmesi
        GenericClass<Integer> intInstance = new GenericClass<>(42);
        intInstance.printValue(); // Çıktı: Value: 42

        GenericClass<String> stringInstance = new GenericClass<>("Merhaba Dünya");
        stringInstance.printValue(); // Çıktı: Value: Merhaba Dünya

        GenericClass<Double> doubleInstance = new GenericClass<>(3.14);
        doubleInstance.printValue(); // Çıktı: Value: 3.14

        // 2. Stream API ile öğe arama
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println(findElement(intArray, 3)); // Çıktı: 3
        System.out.println(findElement(intArray, 10)); // Çıktı: -1

        String[] stringArray = {"Elma", "Armut", "Kiraz"};
        System.out.println(findElement(stringArray, "Armut")); // Çıktı: Armut
        System.out.println(findElement(stringArray, "Muz")); // Çıktı: -1
    }
}
