package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                        .boxed()
        .toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) { // 1вото четно
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) { // второто четно
                return 1;
            }
            // двете са четни или двете са нечетни

            return first.compareTo(second);
        };
        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}