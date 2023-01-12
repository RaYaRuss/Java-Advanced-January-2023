package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String input = scanner.nextLine();
//
//        String currentUrl = null; // променливата не е инициализирана, ще има такова нещо, но то все още не съществува
//
//        ArrayDeque<String> history = new ArrayDeque<>();
//
//        while (!input.equals("Home")) {
//
//            if (input.equals("back")) {
//
//                if (history.isEmpty()) {
//                    System.out.println("no previous URLs");
//                    input = scanner.nextLine();
//                    continue;
//                } else {
//                    currentUrl = history.pop();
//                }
//            } else {
//                if (currentUrl != null) {
//                    history.push(currentUrl);
//                }
//                currentUrl = input;
//            }
//            System.out.println(currentUrl);
//
//            input = scanner.nextLine();
//        }

        Deque<String> history = new ArrayDeque<>();
         String currentInput = scanner.nextLine();

         while (!currentInput.equals("Home")) {
             if (currentInput.equals("back")) {
                 if (history.isEmpty() || history.size() == 1) {
                     System.out.println("no previous URLs");
                     currentInput = scanner.nextLine();

                     continue;
                 }

                 history.pop();
             } else {
                 history.push(currentInput);
             }

             System.out.println(history.peek());

             currentInput = scanner.nextLine();
         }
    }
}
