package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int rowA = -1;
        int colA = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("A")) {
                    rowA = row;
                    colA = col;
                    break;
                }
            }
        }

        List<Integer> mirrorCoordinates = new ArrayList<>();

        boolean hasMirrors = false;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("M")) {
                    hasMirrors = true;
                    break;
                }
            }
        }
        if (hasMirrors) {
            findMirrors(matrix, mirrorCoordinates);
        }
        int totalAmount = 0;
        String direction = scanner.nextLine();

        boolean isOut = false;

        while (true) {
            switch (direction) {
                case "right":
                    if (colA + 1 >= size) {
                        isOut = true;
                        break;
                    } else {
                        matrix[rowA][colA] = "-";
                        colA++;
                    }
                    break;
                case "left":
                    if (colA - 1 < 0) {
                        isOut = true;
                        break;
                    } else {
                        matrix[rowA][colA] = "-";
                        colA--;
                    }
                    break;
                case "up":
                    if (rowA - 1 < 0) {
                        isOut = true;
                        break;
                    } else {
                        matrix[rowA][colA] = "-";
                        rowA--;
                    }
                    break;
                case "down":
                    if (rowA + 1 >= size) {
                        isOut = true;
                        break;
                    } else {
                        matrix[rowA][colA] = "-";
                        rowA++;
                    }
                    break;
            }
            String currentPosition = matrix[rowA][colA];
            if (isOut) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.%n", totalAmount);
                printMatrix(matrix);
                return;
            }
            if (Character.isDigit(currentPosition.charAt(0))) {
                int amount = Integer.parseInt(currentPosition);
                totalAmount += amount;
                matrix[rowA][colA] = "-";

            } else if (currentPosition.equals("M")) {
                rowA = mirrorCoordinates.get(2);
                colA = mirrorCoordinates.get(3);
                matrix[mirrorCoordinates.get(0)][mirrorCoordinates.get(1)] = "-";
                matrix[mirrorCoordinates.get(2)][mirrorCoordinates.get(3)] = "-";
            }

            if (totalAmount >= 65) {
                matrix[rowA][colA] = "A";
                System.out.println("Very nice swords, I will come back for more!");
                System.out.printf("The king paid %d gold coins.%n", totalAmount);
                printMatrix(matrix);
                return;
            }
            direction = scanner.nextLine();
        }
    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
    private static void findMirrors(String[][] matrix, List<Integer> mirrorCoordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    mirrorCoordinates.add(row);
                    mirrorCoordinates.add(col);
                }
            }
        }
    }
}
