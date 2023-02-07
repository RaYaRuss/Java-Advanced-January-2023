package Generics.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstElement = tokens[0];
            String secondElement = tokens[1];
            String thirdElement = tokens[2];
            switch (i) {
                case 0:
                    firstElement = tokens[0] + " " + tokens[1];
                    secondElement = tokens[2];
                    thirdElement = tokens[3];
                    Threeuple<String, String, String> firstTuple = new Threeuple<>(firstElement, secondElement, thirdElement);

                    System.out.println(firstTuple);
                    break;
                case 1:
                    boolean isDrunk = thirdElement.equals("drunk");
                    Threeuple<String, Integer, Boolean> secondTuple =
                            new Threeuple<>(firstElement, Integer.parseInt(secondElement), isDrunk);

                    System.out.println(secondTuple);
                    break;
                case 2:
                    Threeuple<String, Double, String> thirdTuple =
                            new Threeuple<>(firstElement, Double.parseDouble(secondElement), thirdElement);

                    System.out.println(thirdTuple);
                    break;
            }
        }
    }
}
