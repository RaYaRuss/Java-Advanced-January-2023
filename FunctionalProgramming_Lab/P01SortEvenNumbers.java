package FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());

        numbers.removeIf(num -> num % 2 != 0);

//        numbers.forEach(num -> System.out.print(num + ", "));

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        List<Integer> sortedNums = numbers.stream().sorted().collect(Collectors.toList());
//        sortedNums.stream().sorted()
//                .forEach(num -> System.out.print(num));

        printWithSeparator(sortedNums);
    }

    private static void printWithSeparator(List<Integer> sortedNums) {
        for (int i = 0; i < sortedNums.size(); i++) {
            System.out.print(sortedNums.get(i));
            if (i < sortedNums.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
