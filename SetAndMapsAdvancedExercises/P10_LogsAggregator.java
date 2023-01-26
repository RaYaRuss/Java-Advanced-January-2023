package SetAndMapsAdvancedExercises;

import java.util.*;

public class P10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Map<String, TreeSet<String>> dataMap = new TreeMap<>();
        Map<String, Integer> usersDurations = new TreeMap<>();

        while (n > 0) {
            String[] inputArr = input.split("\\s+");

            String ip = inputArr[0];
            String name = inputArr[1];
            int duration = Integer.parseInt(inputArr[2]);

            dataMap.putIfAbsent(name, new TreeSet<>());
            dataMap.get(name).add(ip);

            if (!usersDurations.containsKey(name)) {
                usersDurations.put(name, duration);
            } else {
                usersDurations.put(name, usersDurations.get(name) + duration);
            }


            input = scanner.nextLine();
            n--;
        }
        usersDurations.forEach((key, value) -> {
            System.out.printf("%s: %d %s%n", key, value, dataMap.get(key));
            //System.out.println(String.format("%s: %d %s", key, value, dataMap.get(key).toString()));
        });
    }
}
