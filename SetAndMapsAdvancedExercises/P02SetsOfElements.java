package SetAndMapsAdvancedExercises;

import javax.naming.InsufficientResourcesException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sizeSetOne = Integer.parseInt(input.split("\\s+")[0]);
        int sizeSetTwo = Integer.parseInt(input.split("\\s+")[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int number = 0; number < sizeSetOne; number++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        for (int number = 0; number < sizeSetTwo; number++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

         // начин 1ви:
//        Set<Integer> duplicateElements = new LinkedHashSet<>();
//        for (int number : firstSet) {
//            if (secondSet.contains(number)) {
//                duplicateElements.add(number);
        // или
        // System.out.print(number + " ");
//            }
//        }
//        duplicateElements.forEach(System.out::print);

        // начин 2ри:

        //firstSet.retainAll(secondSet); // маха всички елементи, които ги няма във втория сет
        // в първия сет остават само елементите, които ги има във втория
        //firstSet.forEach(el -> System.out.print(el + " "));

        for (String element : firstSet) {
            if (secondSet.contains(element)) {
                System.out.print(element + " ");
            }
        }
  }
}
