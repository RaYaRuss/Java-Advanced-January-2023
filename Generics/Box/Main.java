package Generics.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Double>> boxes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
           Double data = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(data);
            boxes.add(box);
        }
       // List<Integer> indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
        //       .map(Integer::parseInt)
        //        .collect(Collectors.toList());

        // swap(boxes, indexes.get(0), indexes.get(1));

       Box<Double> boxToCompare = new Box<>(Double.parseDouble(scanner.nextLine()));

        System.out.println(countGreaterResults(boxes, boxToCompare));
    }
//    static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
//        T firstElement = data.get(firstIndex);
//        T secondElement = data.get(secondIndex);
//
//        data.set(firstIndex, secondElement);
//        data.set(secondIndex, firstElement);
//    }
    static <T extends Comparable<T>> int countGreaterResults(List<T> data, T element) {
        int count = 0;
        for (T el : data) {
            int res = el.compareTo(element);
            if (res > 0) {
                count ++;
            }
        }
        return count;
    }
}