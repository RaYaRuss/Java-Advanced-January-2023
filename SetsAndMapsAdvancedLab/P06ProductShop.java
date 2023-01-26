package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shopProductMap = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!shopProductMap.containsKey(shop)) {
                shopProductMap.put(shop, new LinkedHashMap<>());
                shopProductMap.get(shop).put(product, price);
            } else {
                shopProductMap.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }
        shopProductMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            for (Map.Entry<String, Double> product : e.getValue().entrySet()) {
                String output = String.format("Product: %s, Price: %.1f", product.getKey()
                , product.getValue());
                System.out.println(output);
            }
        });

   }
}
