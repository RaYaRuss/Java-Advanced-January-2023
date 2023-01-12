package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> history = new ArrayDeque<>();
        Deque<String> forwardHis = new ArrayDeque<>();
        String currentInput = scanner.nextLine();

        while (!currentInput.equals("Home")) {
            if (currentInput.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                    currentInput = scanner.nextLine();

                    continue;
                }
                forwardHis.addFirst(history.peek());
                history.pop();

            } else if (currentInput.equals("forward")) {
                if (forwardHis.isEmpty()) {
                    System.out.println("no next URLs");
                    currentInput = scanner.nextLine();
                    continue;
                } else {
                    history.push(forwardHis.peek());
                    System.out.println(forwardHis.poll());
                    currentInput = scanner.nextLine();
                    continue;
                }
            } else {
                forwardHis.clear();
                history.push(currentInput);
            }

            System.out.println(history.peek());

            currentInput = scanner.nextLine();
        }
    }
}
