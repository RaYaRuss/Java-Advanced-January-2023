package MidExamPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test_P01_Blacksmith {

    private static final int GLADIUS = 70;
    private static final int SHAMSHIR = 80;
    private static final int KATANA = 90;
    private static final int SABRE = 110;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] steelInfo = scanner.nextLine().split("\\s+");
        Deque<Integer> steel = new ArrayDeque<>();

        for (String liquid : steelInfo) {
            steel.offer(Integer.parseInt(liquid));
        }

        String[] carbonInfo = scanner.nextLine().split("\\s+");
        Deque<Integer> carbon = new ArrayDeque<>();
        for (String ingredient : carbonInfo) {
            carbon.push(Integer.parseInt(ingredient));
        }
        int gladiusCount = 0, shamshirCount = 0, katanaCount = 0, sabreCount = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {
            Integer steelOne = steel.poll();
            Integer carbonOne = carbon.pop();
            int sum = steelOne + carbonOne;

            switch (sum) {
                case GLADIUS:
                    gladiusCount++;
                    break;
                case SHAMSHIR:
                    shamshirCount++;
                    break;
                case KATANA:
                    katanaCount++;
                    break;
                case SABRE:
                    sabreCount++;
                    break;
                default:
                    carbon.push(carbonOne + 5);
                    break;
            }
        }

        if (gladiusCount > 0 || shamshirCount > 0 || katanaCount > 0 || sabreCount > 0) {
            int count = gladiusCount + shamshirCount + katanaCount + sabreCount;
            System.out.printf("You have forged %d swords.%n", count);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        System.out.print("Steel left: ");
        if (steel.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(steel.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Carbon left: ");
        if (carbon.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(carbon.toString().replaceAll("[\\[\\]]", ""));
        }

        if (gladiusCount > 0){
            System.out.println("Gladius: " + gladiusCount);
        }
        if (katanaCount > 0) {
            System.out.println("Katana: " + katanaCount);
        }
        if (sabreCount > 0) {
            System.out.println("Sabre: " + sabreCount);
        }
        if (shamshirCount > 0) {
            System.out.println("Shamshir: " + shamshirCount);
        }
    }
}

