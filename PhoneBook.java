import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> phoneNumbers;

    public PhoneBook() {
        phoneNumbers = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (phoneNumbers.containsKey(lastName)) {
            phoneNumbers.put(lastName, phoneNumbers.get(lastName) + ", " + phoneNumber);
        } else {
            phoneNumbers.put(lastName, phoneNumber);
        }
    }

    public String get(String lastName) {
        if (phoneNumbers.containsKey(lastName)) {
            return phoneNumbers.get(lastName);
        } else {
            return "Номер не найден";
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+37529-600-10-20");
        phoneBook.add("Петров", "+37529-700-10-20");
        phoneBook.add("Иванов", "+37529-200-10-20");
        phoneBook.add("Иванов", "+37529-680-10-20");
        phoneBook.add("Смирнов", "+37529-700-10-20");



        System.out.println("Телефонные номера для Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Телефонные номера для Петров: " + phoneBook.get("Петров"));
        System.out.println("Телефонные номера для Сидоров: " + phoneBook.get("Сидоров")); 
    }
}
