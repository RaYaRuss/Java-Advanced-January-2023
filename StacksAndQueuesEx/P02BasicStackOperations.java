package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int countToPush = Integer.parseInt(input[0]); // count of elements
        int countToPop = Integer.parseInt(input[1]); // count of elements to pop
        int elementToSearch = Integer.parseInt(input[2]); // number we are looking for

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] numbersToAdd = scanner.nextLine().split(" ");
        for (int i = 0; i < countToPush; i++) {
            stack.push(Integer.parseInt(numbersToAdd[i]));
        }

        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(elementToSearch)) {
            System.out.println(true);
        } else {
            // pyrvi variant
//            int minElement = Integer.MAX_VALUE;
//            for (Integer number : stack) {
//                if (number < minElement) {
//                    minElement = number;
//                }
//            }
            // vtori variant
//            int minElement = Collections.min(stack);
            // treti variant
            int minElement = stack.stream().mapToInt(e -> e).min().getAsInt();
            System.out.println(minElement);
        }
    }
}
