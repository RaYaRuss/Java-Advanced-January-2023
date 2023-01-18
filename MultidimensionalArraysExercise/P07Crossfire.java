package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List <List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]); // показва индекса на елемента
            int radius = Integer.parseInt(tokens[2]);

            // махаме отдолу и отгоре
            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInMatrix(currentRow, col, matrix)) {
                    matrix.get(currentRow).remove(col);
                }
            }
            // махаме елементи наляво и надясно
            for (int currentCol = col + radius; currentCol >= col - radius; currentCol--) {
                if (isInMatrix(row, currentCol, matrix)) {
                    matrix.get(row).remove(currentCol);
                }
            }
            matrix.removeIf(List::isEmpty);
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInMatrix( int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }
    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
