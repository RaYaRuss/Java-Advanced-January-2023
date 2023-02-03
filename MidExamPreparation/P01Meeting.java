package MidExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(femaleQueue::offer);

        int matchesCount = 0;
        while (maleStack.size() != 0 && femaleQueue.size() != 0) {
            if (isDivisible(maleStack.getLast())) {
                maleStack.pop();
                if (!maleStack.isEmpty()) {
                    maleStack.pop();
                }
            }
            if (isDivisible(femaleQueue.getFirst())) {
                femaleQueue.poll();
                if (!femaleQueue.isEmpty()) {
                    femaleQueue.poll();
                }
            }
            if (!maleStack.isEmpty() && maleStack.peek() <= 0) {
                maleStack.pop();
                continue;
            }
            if (!femaleQueue.isEmpty() && femaleQueue.peek() <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (maleStack.peek() == femaleQueue.peek()) {
                maleStack.pop();
                femaleQueue.poll();
                matchesCount++;
            } else if (!femaleQueue.isEmpty() && maleStack.peek() != femaleQueue.peek()){
                femaleQueue.poll();
                int malesNumber = maleStack.peek();
                maleStack.pop();
                maleStack.push(malesNumber - 2);
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);
        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s%n", String.join(", ",Arrays.asList(maleStack.toString()
                    .substring(1, maleStack.toString().length() - 1))));
        }
        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s%n", String.join(", ",Arrays.asList(femaleQueue.toString()
                    .substring(1, femaleQueue.toString().length() - 1))));
        }
    }
    public static boolean isDivisible(int number){
        if (number % 25 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
