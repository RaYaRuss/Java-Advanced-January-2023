package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endOfRange = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToDivide = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivide : numbersToDivide) {
                if (number % numberToDivide != 0) {
                    return false;
                }
            }
            return  true;
        };

        // друг вариант
//        IntStream.rangeClosed(1, endOfRange).boxed().filter(isDivisible)
//                .forEach(number -> System.out.print(number + " ") );

        for (int number = 1; number <= endOfRange; number++) {
            if (isDivisible.test(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
