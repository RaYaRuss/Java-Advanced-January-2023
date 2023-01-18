package MultidimensionalArraysExercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        char startLetter = 'a';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String result = "" + startLetter + (char)(startLetter + j) + startLetter;

                matrix[i][j] = result;
            }
            startLetter = (char)(startLetter + 1);
        }

        printMatrix(matrix, rows, cols);
    }
    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
