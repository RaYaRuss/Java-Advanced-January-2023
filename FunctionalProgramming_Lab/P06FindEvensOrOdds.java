package FunctionalProgramming_Lab;

import org.w3c.dom.ranges.Range;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String oddOrEven = scanner.nextLine();

        // 1ви начин
        Predicate<Integer> filterCondition =
                oddOrEven.equals("odd") ?
                        (x -> x % 2 != 0) :
                        (x -> x % 2 == 0);

        // 2ри начин
//        Predicate<Integer> other;
//        if (oddOrEven.equals("odd")) {
//            other = x -> x % 2 != 0;
//        } else {
//            other = x -> x % 2 == 0;
//        }
        // 3ти начин
//        Predicate<Integer> third = x -> x % 2 == 0;
//        if (oddOrEven.equals("odd")) {
//            third = x -> x % 2 != 0;
//        }

        IntStream.rangeClosed(lowerBound, upperBound)
                .filter(num -> filterCondition.test(num))
                .forEach(num -> System.out.print(num + " "));
    }
}
