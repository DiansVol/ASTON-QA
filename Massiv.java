import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Massiv {
    public static void main(String[] args) {
        List<String> kaupungi = Arrays.asList("Кот", "Собака", "Рыба", "Птица", "Котрова", "Каза",
                "Кот", "Конь", "Ёж", "Рыба", "Собака", "Дерево", "Кролик", "Птица");
        System.out.println("Исходный список:");
        kaupungi.forEach(System.out::println);

        System.out.println("\nСводка:");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : kaupungi) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : wordsCount.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("\nБез повторов: ");
        Set<String> unique = new HashSet<>(kaupungi);
        unique.forEach(System.out::println);

    }
}
