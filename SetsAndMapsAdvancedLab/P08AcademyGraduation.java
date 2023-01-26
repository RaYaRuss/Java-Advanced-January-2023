package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                int n = Integer.parseInt(scanner.nextLine());

                Map<String, ArrayList<Double>> averageGradeByStudents = new TreeMap<>();

                while (--n >= 0) {
                    String name = scanner.nextLine();
                    double[] grades = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToDouble(Double::parseDouble)
                            .toArray();

                    averageGradeByStudents.putIfAbsent(name, new ArrayList<>());

                    for (double grade : grades) {
                        averageGradeByStudents.get(name).add(grade);
                    }

                }
                averageGradeByStudents.forEach((key, value) -> {
                    double sumOfGrades = 0;
                    for (Double grade : value) {
                        sumOfGrades += grade;
                    }
                    System.out.printf("%s is graduated with %s%n", key, sumOfGrades / value.size());
                });
            }
        }


//        int studentCount = Integer.parseInt(scanner.nextLine());
//
//        Map<String, Double[]> gradesPerStudent = new TreeMap<>();
//
//        for (int i = 0; i < studentCount; i++) {
//            String name = scanner.nextLine();
//            String[] inputGrades = scanner.nextLine().split(" ");
//            Double[] grades = new Double[inputGrades.length];
//
//            for (int j = 0; j < inputGrades.length; j++) {
//                grades[j] = Double.parseDouble(inputGrades[j]);
//            }
//
//            gradesPerStudent.put(name, grades);
//        }
//
//        DecimalFormat format = new DecimalFormat("0.####");
//        for (String studentName : gradesPerStudent.keySet()) {
//            Double[]grades = gradesPerStudent.get(studentName);
//
//            double sum = 0;
//            for (Double grade : grades) {
//                sum += grade;
//            }
//            System.out.printf("%s is graduated with %f%n", studentName, format.format(sum / grades.length));
//        }
//    }
//}
