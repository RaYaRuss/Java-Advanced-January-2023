package MidExamPreparation;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner);

        int rowPlayer = -1;
        int colPlayer = -1;
        boolean reachFinish = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'P') {
                    rowPlayer = i;
                    colPlayer = j;
                }
            }
            if (rowPlayer != -1) {
                break;
            }
        }
        matrix[rowPlayer][colPlayer] = '.';
        String command = scanner.nextLine();
        while (commandsCount > 0) {
            switch (command) {
                case "up":
                    if (rowPlayer > 0) {
                        rowPlayer--;
                    } else {
                        rowPlayer = matrix.length - 1;
                    }
                    if (matrix[rowPlayer][colPlayer] == 'T') {
                        if (rowPlayer != matrix.length - 1) {
                            rowPlayer++;

                        } else {
                            rowPlayer = 0;
                        }
                        command = scanner.nextLine();
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'F') {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPlayer][colPlayer] = 'P';
                        printMatrix(matrix);
                        return;
                    }
                    matrix[rowPlayer][colPlayer] = '.';
                    break;
                case "down":
                    if (rowPlayer < matrix.length - 1) {
                        rowPlayer++;
                    } else {
                        rowPlayer = 0;
                    }
                    if (matrix[rowPlayer][colPlayer] == 'T') {
                        if (rowPlayer != 0) {
                            rowPlayer--;
                        } else {
                            rowPlayer = matrix.length - 1;
                        }
                        command = scanner.nextLine();
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'F') {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPlayer][colPlayer] = 'P';
                        printMatrix(matrix);
                        return;
                    }
                    matrix[rowPlayer][colPlayer] = '.';
                    break;
                case "right":
                    if (colPlayer < matrix.length - 1) {
                        colPlayer++;
                    } else {
                        colPlayer = 0;
                    }
                    if (matrix[rowPlayer][colPlayer] == 'T') {
                        if (colPlayer != 0) {
                            colPlayer--;
                        } else {
                            colPlayer = matrix.length - 1;
                        }
                        command = scanner.nextLine();
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'F') {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPlayer][colPlayer] = 'P';
                        printMatrix(matrix);
                        return;
                    }
                    matrix[rowPlayer][colPlayer] = '.';
                    break;
                case "left":
                    if (colPlayer > 0) {
                        colPlayer--;
                    } else {
                        colPlayer = matrix.length - 1;
                    }
                    if (matrix[rowPlayer][colPlayer] == 'T') {
                        if (colPlayer != matrix.length - 1) {
                            colPlayer++;
                        } else {
                            colPlayer = 0;
                        }
                        command = scanner.nextLine();
                        continue;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        continue;
                    }
                    if (matrix[rowPlayer][colPlayer] == 'F') {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPlayer][colPlayer] = 'P';
                        printMatrix(matrix);
                        return;
                    }
                    matrix[rowPlayer][colPlayer] = '.';
                    break;
            }
            commandsCount--;
            if (commandsCount != 0) {
                command = scanner.nextLine();
            } else {
                matrix[rowPlayer][colPlayer] = 'P';
                System.out.println("Oh no, the player got lost on the track!");
                printMatrix(matrix);
                break;
            }
        }
    }
        private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();
        }
    }
        }