package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayDeque<String> printerQueue = new ArrayDeque<>();
//        String input = scanner.nextLine();
//
//        while (!input.equals("print")) {
//
//            if (input.equals("cancel")) {
//                // ternalen operator = ako printerQue is empty (True) shte se izpylni sled"?,
//                // ako e false - shte se wyrne i prosvoi stojnost na output sled ":";
//                String output = printerQueue.isEmpty()
//                        ?"Printer is on standby"
//                        :"Canceled " + printerQueue.poll();
//
//                System.out.println(output);
//            } else {
//                printerQueue.offer(input);
//            }
//
//            input = scanner.nextLine();
//        }
//
//        // otpechatvane na oprashka - ili s for each, ili s while
//        for (String s : printerQueue) {
//            System.out.println(s);
//        }
//        while (!printerQueue.isEmpty()) {
//            System.out.println(printerQueue.poll());
//        }

        String currentInput = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while (!currentInput.equals("print")) {
            if (currentInput.equals("cancel")) {
                String firstTask = printerQueue.poll();

                if (firstTask == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Cancelled " + firstTask);
                }
            } else {
                printerQueue.offer(currentInput);
            }

            currentInput = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
