package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            String[] columnData = scanner.nextLine().split(" ");

            int[] currentRow = Arrays.stream(columnData).mapToInt(elem -> Integer.parseInt(elem)).toArray();

            matrix[row] = currentRow;
        }

        String[] input = scanner.nextLine().split(" ");
        int rowToFix = Integer.parseInt(input[0]);
        int colToFix = Integer.parseInt(input[1]);

        int currentElem = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == rowToFix && j == colToFix) {
                    currentElem = matrix[i][j];
                }
                if (matrix[i][j] == currentElem) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j + 1] + matrix[i + 1][j];
                    } else {
                        matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
                    }
                }
            }
            for (int m = 0; m < matrix.length; m++) {
                for (int k = 0; k < matrix[m].length; k++) {
                    System.out.print(matrix[m][k] + " ");
                }
            }
        }
    }
}
