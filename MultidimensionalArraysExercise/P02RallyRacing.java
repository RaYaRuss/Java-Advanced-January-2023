package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();
        int km = 0; // изминатите км от колата

        String[][] trace = new String[n][n];

        fillMatrix(trace, scanner);

        int currentRow = 0; //ред,на който се намира колата
        int currentCol = 0; // колона, на която се намира колата

        // намираме 2та тунела
        // тунел 1 -> ред и колона
        // тунел 2 -> ред и колона
        // лист с 4ри елемента -1ви ел-т- ред на тунел1; 2ри ел. колоната на 1ви тунел и т.н.

        List<Integer> tunnelCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelCoordinates);

        int countTunnels = 0;

        // започваме движение
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {
            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String movedPlaced = trace[currentRow][currentCol]; // място по трасето, на което сме се преместили;

            if (movedPlaced.equals(".")) {
                km += 10;
            } else if (movedPlaced.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            } else if (movedPlaced.equals("T")) {

                    // отиваме до другия тунел
                    // трябват координатите на клата да == кординатите на тунел 2
                    currentRow = tunnelCoordinates.get(2);
                    currentCol = tunnelCoordinates.get(3);
                    km += 30;
                    //заместваме тунелите с точка, защото вече сме преминали
                    trace[tunnelCoordinates.get(0)][tunnelCoordinates.get(1)] = ".";
                    trace[tunnelCoordinates.get(2)][tunnelCoordinates.get(3)] = ".";
            }
            direction = scanner.nextLine();
        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", km);
        // там където е колата, слагаме "С"
        trace[currentRow][currentCol] = "C";
        printMatrix(trace, n, n);
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                if (trace[row][col].equals("T")) {
                    tunnelCoordinates.add(row);
                    tunnelCoordinates.add(col);
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}