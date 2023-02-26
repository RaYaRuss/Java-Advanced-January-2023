package MidExamPreparation;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .forEach(tulipsStack::push);
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

        int count = 0;
        int sumUnsortedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int currentTulip = tulipsStack.pop();
            int currentDaffodil = daffodilsQueue.poll();
            int sum = currentDaffodil + currentTulip;

            if (sum == 15) {
                count++;
                
            } else if (sum > 15) {
                currentTulip -= 2;
                tulipsStack.push(currentTulip);
                daffodilsQueue.addFirst(currentDaffodil);
            } else if (sum < 15) {
                sumUnsortedFlowers += sum;
            }
        }
        if (sumUnsortedFlowers > 15) {
            int bouquets = sumUnsortedFlowers / 15;
            count += bouquets;
        }

        if (count >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", count);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", (5 - count));
        }
    }
}
