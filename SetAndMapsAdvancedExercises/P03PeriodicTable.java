package SetAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countRows = Integer.parseInt(scanner.nextLine());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < countRows; i++) {
            String input = scanner.nextLine();
            String[] inputLineArr = input.split(" ");
            for (int j = 0; j < inputLineArr.length; j++) {
                String element = input.split(" ")[j];
                compounds.add(element);
            }
        }
        for (String el : compounds) {
            System.out.print(el + " ");
        }
    }
}