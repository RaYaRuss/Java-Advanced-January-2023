package SetAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> emailsDataMap = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            // за втори вид решение
            // emailsDataMap.put(name, email);

            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                emailsDataMap.put(name, email);
            }
            name = scanner.nextLine();
        }
 // за втори вид решение с removeIf - премахва всички записи, които отговарят на условието
//        emailsDataMap.entrySet().removeIf(entry -> entry.getValue().endsWith("uk") ||
//                entry.getValue().endsWith("us") || entry.getValue().endsWith("com"));

        emailsDataMap.entrySet().forEach(entry -> System.out.println(
                entry.getKey() + " -> " + entry.getValue()));
    }
}
