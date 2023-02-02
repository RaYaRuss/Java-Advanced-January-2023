package MidExamPreparation;

import java.util.*;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackDailyPortion = new ArrayDeque<>();
        ArrayDeque<Integer> queueStamina = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(stackDailyPortion::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(queueStamina::offer);

        List<String> peaks = new ArrayList<>();
        peaks.add("Vihren-80");
        peaks.add("Kutelo-90");
        peaks.add("Banski Suhodol-100");
        peaks.add("Polezhan-60");
        peaks.add("Kamenitza-70");

        List<String> conqueredPeaks = new ArrayList<>();

        boolean isOver = false;

        while(!peaks.isEmpty() && !queueStamina.isEmpty() && !stackDailyPortion.isEmpty()) {
            int currentSum = stackDailyPortion.peek() + queueStamina.peek();
            if (currentSum >= Integer.parseInt(peaks.get(0).split("-")[1])) {
                stackDailyPortion.pop();
                queueStamina.poll();
                conqueredPeaks.add(peaks.get(0).split("-")[0]);
                peaks.remove(0);

            } else if (currentSum < Integer.parseInt(peaks.get(0).split("-")[1])) {
                stackDailyPortion.pop();
                queueStamina.poll();
            }
        }
            if (peaks.isEmpty()) {
                isOver = true;
                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            }
            if (!peaks.isEmpty()) {
                isOver = true;
                System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            }
            if (isOver && conqueredPeaks.size() > 0) {
                System.out.println("Conquered peaks:");
                for (String name : conqueredPeaks) {
                    System.out.println(name);
                }
            }
        }
    }

