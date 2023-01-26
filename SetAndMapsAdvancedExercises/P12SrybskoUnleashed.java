package SetAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P12SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = scanner.nextLine();
                continue;
            }


            String singer = input.substring(0, input.indexOf("@") - 1);
            int indexOfFirstNumber = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    indexOfFirstNumber = i;
                    break;
                }
            }
            if (indexOfFirstNumber == 0) {
               continue;
            }

            String venue = input.substring(input.indexOf("@") + 1, indexOfFirstNumber - 1);
            String numbers = input.substring(indexOfFirstNumber);

            if (numbers.split(" ").length != 2) {
                input = scanner.nextLine();
                continue;
            }
            int price = Integer.parseInt(numbers.split(" ")[0]);
            int capacity = Integer.parseInt(numbers.split(" ")[1]);

            if (!concerts.containsKey(venue)) {
                LinkedHashMap <String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                concerts.put(venue, singers);

            } else {
                LinkedHashMap<String, Integer> currentSingers = concerts.get(venue);
                if (currentSingers.containsKey(singer)) {
                    currentSingers.put(singer, currentSingers.get(singer) + price * capacity);

                } else {
                    currentSingers.put(singer, price * capacity);
                }
                concerts.put(venue, currentSingers);
            }

            input = scanner.nextLine();

        }
        for (String venue : concerts.keySet()) {
            System.out.println(venue);

            LinkedHashMap<String, Integer> singers = concerts.get(venue);
            singers.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));

        }
    }
}
