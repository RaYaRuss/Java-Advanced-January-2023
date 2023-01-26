package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.function.DoubleFunction;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> nameGradesMap = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentName = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!nameGradesMap.containsKey(studentName)) {
            nameGradesMap.put(studentName, new ArrayList<>());
                nameGradesMap.get(studentName).add(grade);
             } else {
                nameGradesMap.get(studentName).add(grade);
            }
        }
        nameGradesMap.entrySet().stream()
                .forEach(entry -> { double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                double average = sum / entry.getValue().size();
                    System.out.print(entry.getKey() + " -> ");
                entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", average);
                });
        }
    }
