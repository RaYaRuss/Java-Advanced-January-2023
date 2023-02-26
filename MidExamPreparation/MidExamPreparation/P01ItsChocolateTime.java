package MidExamPreparation;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).forEach(milkQueue::offer);
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).forEach(cacaoStack::push);

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        double cacaoPercentage = 0;
        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {

            double milkValue = milkQueue.peek();
            double cacaoValue = cacaoStack.peek();
            cacaoPercentage = (cacaoValue / (milkValue + cacaoValue)) * 100;

            if (cacaoPercentage == 30) {
                milkQueue.poll();
                cacaoStack.pop();
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else if (cacaoPercentage == 50) {
                milkQueue.poll();
                cacaoStack.pop();
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (cacaoPercentage == 100) {
                milkQueue.poll();
                cacaoStack.pop();
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else {
                cacaoStack.pop();
                milkValue += 10;
                milkQueue.poll();
                milkQueue.addLast(milkValue);
            }

        }

        if (haveAll(chocolates)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            printMap(chocolates);
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            printMap(chocolates);
        }
    }

    private static void printMap(Map<String, Integer> chocolates) {
        chocolates.entrySet().stream().forEach(ch -> {
            int value = ch.getValue();
            if (ch.getValue() > 0)
                System.out.println("# " + ch.getKey() + " --> " + value );
        });
    }

    private static boolean haveAll(Map<String, Integer> chocolates) {
        boolean done = false;
        for (int value : chocolates.values()) {
            if (value == 0) {
                done = false;
                break;
            } else {
                done = true;
            }
        }
        return done;
    }
}
