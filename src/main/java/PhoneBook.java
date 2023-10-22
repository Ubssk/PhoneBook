import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }

    public void removeContact(String name) {
        phoneBook.remove(name);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иванов", "123456789");
        phoneBook.addContact("Петров", "987654321");
        phoneBook.addContact("Сидоров", "555555555");
        phoneBook.addContact("Иванов", "111111111");
        phoneBook.addContact("Петров", "222222222");
        phoneBook.addContact("Степанова", "123456789");
        phoneBook.addContact("Евсеева", "555555");
        phoneBook.addContact("Степанова", "7894567");
        phoneBook.addContact("Степанова", "123789");

        phoneBook.printPhoneBook();
    }
}
