package SetAndMapsAdvancedExercises;

import java.util.*;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Long>> countryCityMap = new LinkedHashMap<>();
        LinkedHashMap<String, Long> totalPopulationMap = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] inputLine = input.split("\\|");
            String city = inputLine[0];
            String country = inputLine[1];
            long population = Long.parseLong(inputLine[2]);


            countryCityMap.putIfAbsent(country, new LinkedHashMap<>());

            countryCityMap.get(country).put(city, population);

            if (!totalPopulationMap.containsKey(country)) {
                totalPopulationMap.put(country, population);
            } else {
                totalPopulationMap.put(country, totalPopulationMap.get(country) + population);
            }

            input = scanner.nextLine();
        }
        totalPopulationMap.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed())
                .forEach(e -> {
                    System.out.println(e.getKey() + " (total population: " + e.getValue() +")");
                    String country = e.getKey();
                    countryCityMap.get(country).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach( el -> System.out.println("=>" + el.getKey() +": " + el.getValue()));
                });
    }
}
