package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, rows, cols, scanner);
        int maxSum = getMaxSum(matrix);
        List<Integer> coordinates = new ArrayList<>();
        findCoordinates(matrix, coordinates, maxSum);

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix, coordinates);
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            String[] parts = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(parts[col]);
            }
        }
    }

    private static int getMaxSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > sum) {
                    sum = currentSum;
                }
            }
        }
        return sum;
    }

    private static void findCoordinates(int[][] matrix, List<Integer> coordinates, int sum) {
        int startIndexRow = 0;
        int startIndexCol = 0;
        for (int i = 0; i < matrix.length - 2; i++ ) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum == sum) {
                    startIndexRow = i;
                    startIndexCol = j;
                    coordinates.add(startIndexRow);
                    coordinates.add(startIndexCol);
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix, List<Integer> coordinates) {
        for (int row = coordinates.get(0); row <= coordinates.get(0) + 2; row++) {
            for (int col = coordinates.get(1); col <= coordinates.get(1) + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}