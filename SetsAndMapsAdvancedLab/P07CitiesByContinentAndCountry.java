package SetsAndMapsAdvancedLab;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> townsMap = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");

            String continent = inputData[0];
            String country = inputData[1];
            String city = inputData[2];

            if (!townsMap.containsKey(continent)) {
                townsMap.put(continent, new LinkedHashMap<>());
                townsMap.get(continent).put(country, new ArrayList<>());
                townsMap.get(continent).get(country).add(city);
            } else {
                if (!townsMap.get(continent).containsKey(country)) {
                    townsMap.get(continent).put(country, new ArrayList<>());
                    townsMap.get(continent).get(country).add(city);
                } else {
                    townsMap.get(continent).get(country).add(city);
                }
            }
        }

        townsMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream()
                    .forEach(country -> {
                        String output = String.join(", ",country.getValue());
                        System.out.println(" " + country.getKey() + " -> " + output);
                    });
        });
    }
}
