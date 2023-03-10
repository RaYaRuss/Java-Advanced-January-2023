package MidExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

//        Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .forEach(threadsQueue::offer);

        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int endTaskNum = Integer.parseInt(scanner.nextLine());

        int task = tasksStack.peek();
        int thread = threadsQueue.peek();

        while (task != endTaskNum) {

            if (thread >= task) {
                tasksStack.pop();
            }
                threadsQueue.poll();


            task = tasksStack.peek();
            thread = threadsQueue.peek();
        }

        System.out.println("Thread with value " +  threadsQueue.peek() +
                " killed task " + endTaskNum);

        String leftThreads = threadsQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(leftThreads);
    }
}
