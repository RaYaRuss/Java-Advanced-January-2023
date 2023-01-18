package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandRotation = scanner.nextLine();
        int angleOfRotation = Integer.parseInt(commandRotation.split("[()]+")[1]) % 360;

        ArrayList<String> linesForMatrix = new ArrayList<>();
        int maxLength = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            linesForMatrix.add(line);
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        int rows = linesForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < linesForMatrix.get(i).length()) {
                    matrix[i][j] = linesForMatrix.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }
        rotate(angleOfRotation, rows, cols, matrix);
    }

    private static void rotate(int angleOfRotation, int rows, int cols, char[][] matrix) {
        if (angleOfRotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (angleOfRotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleOfRotation == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
//    private static void printMatrix(char[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
