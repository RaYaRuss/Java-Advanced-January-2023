package MidExamPreparation;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(steelQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(carbonStack::push);

        int count = 0;
        Map<String, Integer> forgedSwords = new TreeMap<>();
        forgedSwords.put("Gladius", 0);
        forgedSwords.put("Shamshir", 0);
        forgedSwords.put("Katana", 0);
        forgedSwords.put("Sabre", 0);
        while (!carbonStack.isEmpty() && !steelQueue.isEmpty()) {
            int firstSteel = steelQueue.poll();
            int lastCarbon = carbonStack.pop();
            int sum = firstSteel + lastCarbon;
            if (sum == 70) {
                forgedSwords.put("Gladuis", forgedSwords.get("Gladuis") + 1);
                count++;
            } else if (sum == 80) {
                forgedSwords.put("Shamshir", forgedSwords.get("Shamshir") + 1);
                count++;
            } else if (sum == 90) {
                forgedSwords.put("Katana", forgedSwords.get("Katana") + 1);
                count++;
            } else if (sum == 110) {
                forgedSwords.put("Sabre", forgedSwords.get("Sabre") + 1);
                count++;
            } else {
                lastCarbon += 5;
                carbonStack.push(lastCarbon);
            }
        }
        if (count > 0) {
            System.out.printf("You have forged %d swords.%n", count);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.println(steelQueue.toString().replaceAll("[\\[\\]]", ""));
        }
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbonStack.toString().replaceAll("[\\[\\]]", ""));
        }
        forgedSwords.entrySet().stream().forEach(sw -> {
            int value = sw.getValue();
            if (sw.getValue() > 0)
                System.out.println(sw.getKey() + ": " + value );
        });
    }
}

