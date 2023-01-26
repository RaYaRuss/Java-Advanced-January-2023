package SetAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> output = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (!output.containsKey(current)) {
                output.put(current, 1);
            } else {
                output.put(current, output.get(current) + 1);
            }
        }
        output.entrySet().forEach((e -> System.out.printf(e.getKey() + ": " + e.getValue()
        + " " + "time/s%n")));
    }
}
