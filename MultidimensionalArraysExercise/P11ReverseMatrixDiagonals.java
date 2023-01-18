package MultidimensionalArraysExercise;

import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int [][] matrix = new int[rows][cols];

        fillTheMatrix(matrix, rows, cols, scanner);
        printDiagonals(matrix, rows, cols);

    }

    private static void printDiagonals(int[][] matrix, int rows, int cols) {
        int row = rows - 1;
        int col = cols - 1;
        while (row !=  -1) {
            int r = row;
            int c = col;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static void fillTheMatrix(int [][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

    }
}
