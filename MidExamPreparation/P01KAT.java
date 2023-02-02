package MidExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLicensePlates = new ArrayDeque<>();
        ArrayDeque<Integer> stackCarsNumber = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(queueLicensePlates::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(stackCarsNumber::push);

        int countDays = 0;
        int totalRegisteredCars = 0;
        while (!queueLicensePlates.isEmpty() && !stackCarsNumber.isEmpty()) {
            int currentRegisteredCars = 0;
            if (queueLicensePlates.peek() == stackCarsNumber.peek() * 2) {
                currentRegisteredCars = queueLicensePlates.peek() / 2;
                totalRegisteredCars += currentRegisteredCars;
                queueLicensePlates.poll();
                stackCarsNumber.pop();
                countDays++;
            } else if (queueLicensePlates.peek() > stackCarsNumber.peek() * 2) {
                currentRegisteredCars = stackCarsNumber.peek();
                int leftPlates = queueLicensePlates.peek() - (currentRegisteredCars * 2);
                queueLicensePlates.poll();
                stackCarsNumber.pop();
                queueLicensePlates.offer(leftPlates);
                countDays++;
                totalRegisteredCars += currentRegisteredCars;
            } else if (stackCarsNumber.peek() * 2 > queueLicensePlates.peek() ) {
                currentRegisteredCars = queueLicensePlates.peek() / 2;
                int leftCars = stackCarsNumber.peek() - currentRegisteredCars;
                queueLicensePlates.poll();
                stackCarsNumber.pop();
                stackCarsNumber.addLast(leftCars);
                totalRegisteredCars += currentRegisteredCars;
                countDays++;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", totalRegisteredCars, countDays);
        if (!queueLicensePlates.isEmpty()) {
            int sumLeftPlates = 0;
            for (int plate : queueLicensePlates) {
                sumLeftPlates += plate;
            }
            System.out.printf("%d license plates remain!%n", sumLeftPlates);
        }
        if (!stackCarsNumber.isEmpty()) {
            int countLeftCars = 0;
            for (int car : stackCarsNumber) {
                countLeftCars += car;
            }
            System.out.printf("%d cars remain without license plates!%n", countLeftCars);
        }
        if (stackCarsNumber.isEmpty() && queueLicensePlates.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
