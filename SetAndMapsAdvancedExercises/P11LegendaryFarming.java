package SetAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                // shards -> количество
                //fragments -> количество
                // motes -> количество

                //запис: материал -> количество
                Map<String, Integer> items = new LinkedHashMap<>();
                items.put("shards", 0);
                items.put("fragments", 0);
                items.put("motes", 0);

                Map<String, Integer> junkItems =new LinkedHashMap<>();
                boolean isWin = false;

                while (!isWin) {

                    String input = scanner.nextLine();
                    String[] inputData = input.split(" ");
                    for (int index = 0; index < inputData.length; index += 2) {
                        int quantity = Integer.parseInt(inputData[index]);
                        String material = inputData[index + 1].toLowerCase();

                        if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                            // валиден материал
                            int currentQuantity = items.get(material);
                            items.put(material, currentQuantity + quantity);
                        } else {
                            // материалът е боклук
                            if (!junkItems.containsKey(material)) {
                                junkItems.put(material, quantity);
                            } else {
                                int current = junkItems.get(material);
                                junkItems.put(material, current + quantity);
                            }
                        }
                        //обработени всички материали
                        //правим проверка дали не сме спечелили
                        if (items.get("shards") >= 250) {
                            System.out.println("Shadowmourne obtained!");
                            items.put("shards", items.get("shards") - 250);
                            isWin = true;
                            break;
                        } else if (items.get("fragments") >= 250) {
                            System.out.println("Valanyr obtained!");
                            items.put("fragments", items.get("fragments") - 250);
                            isWin = true;
                            break;
                        } else if (items.get("motes")>= 250) {
                            System.out.println("Dragonwrath obtained!");
                            items.put("motes", items.get("motes") - 250);
                            isWin = true;
                            break;
                        }
                    }
                    if(isWin) {
                        break;
                    }
                }

                // отпезатваме всички специални материали

                //items.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
                // отпезатваме всички други материали
                //junkItems.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

                items.entrySet().stream()
                        .sorted((l, r) -> {
                            if (l.getValue().compareTo(r.getValue()) == 0) {
                                return l.getKey().compareTo(r.getKey());
                            } else {
                               return  (r.getValue().compareTo(l.getValue()));
                            }
                        }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

                junkItems.entrySet().stream().sorted((l, r) -> {
                    return l.getKey().compareTo(r.getKey());

                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
            }
}

