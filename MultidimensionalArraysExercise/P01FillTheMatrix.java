package MultidimensionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int [n][n];

        if (pattern.equals("A")) {
            // обхождане матрицата по колони
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            // обхождаме по колони, но на четна колона отдолу нагоре, нечетни отгоре надолу;(започваме от 0)
            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
    }
    private static void  fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1)% 2 == 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = 0; row <= matrix.length - 1; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
