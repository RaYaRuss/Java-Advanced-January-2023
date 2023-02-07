package Generics.Tuple;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 3; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstElement = tokens[0];
            String secondElement = tokens[1];
            switch (i) {
                case 0:
                    firstElement = tokens[0] + " " + tokens[1];
                    secondElement = tokens[2];
                    Tuple<String, String> firstTuple = new Tuple<>(firstElement, secondElement);
                    System.out.println(firstTuple);
                    break;
                case 1:

                    Tuple<String, Integer> secondTuple =
                            new Tuple<>(firstElement, Integer.parseInt(secondElement));
                    System.out.println(secondTuple);
                    break;
                case 2:
                    Tuple<Integer, Double> thirdTuple =
                            new Tuple<>(Integer.parseInt(firstElement),
                                    Double.parseDouble(secondElement));
                    System.out.println(thirdTuple);
                    break;
            }
        }
    }
}
