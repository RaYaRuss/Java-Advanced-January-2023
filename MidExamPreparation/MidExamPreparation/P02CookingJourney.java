package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int rowS = -1;
        int colS = -1;
        List<Integer> pillarsCoordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'S') {
                    rowS = i;
                    colS = j;
                }
            }
            if (rowS != -1) {
                break;
            }
        }

        findPillars(matrix, pillarsCoordinates);

        int money = 0;
        boolean isNotOut = true;

        matrix[rowS][colS] = '-';
        while (isNotOut && money < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (rowS > 0) {
                        rowS--;
                    } else {
                        isNotOut = false;
                    }
                    if (matrix[rowS][colS] >= 48 && matrix[rowS][colS] <= 57 ) {
                        char currentPosition = matrix[rowS][colS];
                        money += Character.getNumericValue(currentPosition);
                        matrix[rowS][colS] = '-';
                    } else if (matrix[rowS][colS] == 'P') {
                        rowS = pillarsCoordinates.get(2);
                        colS = pillarsCoordinates.get(3);
                        matrix[pillarsCoordinates.get(0)][pillarsCoordinates.get(1)] = '-';
                        matrix[pillarsCoordinates.get(2)][pillarsCoordinates.get(3)] = '-';
                    }
                    break;
                case "down":
                    if (rowS < matrix.length - 1) {
                        rowS++;
                    } else {
                        isNotOut = false;
                    }
                    if (matrix[rowS][colS] >= 48 && matrix[rowS][colS] <= 57 ) {
                        char currentPosition = matrix[rowS][colS];
                        money += Character.getNumericValue(currentPosition);
                        matrix[rowS][colS] = '-';
                    } else if (matrix[rowS][colS] == 'P') {
                        rowS = pillarsCoordinates.get(2);
                        colS = pillarsCoordinates.get(3);
                        matrix[pillarsCoordinates.get(0)][pillarsCoordinates.get(1)] = '-';
                        matrix[pillarsCoordinates.get(2)][pillarsCoordinates.get(3)] = '-';
                    }
                    break;
                case "left":
                    if (colS > 0) {
                        colS--;
                    } else {
                        isNotOut = false;
                    }
                    if (matrix[rowS][colS] >= 48 && matrix[rowS][colS] <= 57 ) {
                        char currentPosition = matrix[rowS][colS];
                        money += Character.getNumericValue(currentPosition);
                        matrix[rowS][colS] = '-';
                    } else if (matrix[rowS][colS] == 'P') {
                        rowS = pillarsCoordinates.get(2);
                        colS = pillarsCoordinates.get(3);
                        matrix[pillarsCoordinates.get(0)][pillarsCoordinates.get(1)] = '-';
                        matrix[pillarsCoordinates.get(2)][pillarsCoordinates.get(3)] = '-';
                    }
                    break;
                case "right":
                    if (colS < matrix.length - 1) {
                        colS++;
                    } else {
                        isNotOut = false;
                    }
                    if (matrix[rowS][colS] >= 48 && matrix[rowS][colS] <= 57 ) {
                        char currentPosition = matrix[rowS][colS];
                        money += Character.getNumericValue(currentPosition);
                        matrix[rowS][colS] = '-';
                    } else if (matrix[rowS][colS] == 'P') {
                        rowS = pillarsCoordinates.get(2);
                        colS = pillarsCoordinates.get(3);
                        matrix[pillarsCoordinates.get(0)][pillarsCoordinates.get(1)] = '-';
                        matrix[pillarsCoordinates.get(2)][pillarsCoordinates.get(3)] = '-';
                    }
                    break;
            }
        }

        if (!isNotOut) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        if (money >= 50) {
            matrix[rowS][colS] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void findPillars(char[][] matrix, List<Integer> pillars) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P') {
                    pillars.add(i);
                    pillars.add(j);
                }
            }
        }
    }
    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();
        }
    }
}
