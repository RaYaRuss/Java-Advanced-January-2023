package MidExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] milligramsCaffeine = scanner.nextLine().trim().split(", ");
        String [] energyDrinks = scanner.nextLine().trim().split(", ");

        ArrayDeque<Integer> stackCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> queueEnergyDrinks = new ArrayDeque<>();

       // Arrays.stream(scanner.nextLine().split(",\\s+"))
        //        .mapToInt(Integer::parseInt).forEach(stackCaffeine::push);
        //Arrays.stream(scanner.nextLine().split("\\s+"))
        //      .mapToInt(Integer::parseInt).forEach(queueEnergyDrinks::offer);

        for (String part : milligramsCaffeine) {
            stackCaffeine.push(Integer.parseInt(part));
        }
        for (String part : energyDrinks) {
            queueEnergyDrinks.offer(Integer.parseInt(part));
        }
        int initialCaffeine = 0;

        while(!stackCaffeine.isEmpty() && !queueEnergyDrinks.isEmpty()) {
            int currentCaffeine = stackCaffeine.peek() * queueEnergyDrinks.peek();
            if ((initialCaffeine + currentCaffeine) <= 300) {
                initialCaffeine += currentCaffeine;
                stackCaffeine.pop();
                queueEnergyDrinks.poll();
            } else {
                stackCaffeine.pop();
                int toRemoveAndAdd = queueEnergyDrinks.poll();
                queueEnergyDrinks.offer(toRemoveAndAdd);
                if (initialCaffeine - 30 < 0) {
                    initialCaffeine = 0;
                } else {
                    initialCaffeine -= 30;
                }
            }
        }
        if (!queueEnergyDrinks.isEmpty()) {

            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(queueEnergyDrinks.toString().
                    substring(1, queueEnergyDrinks.toString().length() - 1))));

//            System.out.print("Drinks left: ");
//            int count = queueEnergyDrinks.size() - 1;
//        for ( int drink : queueEnergyDrinks) {
//            if (count == 0) {
//                System.out.print(drink);
//            } else {
//                System.out.print(drink + ", ");
//            }
//            count--;
//        }
        } else {
            System.out.print("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        // System.out.println();
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", initialCaffeine);
    }
}
