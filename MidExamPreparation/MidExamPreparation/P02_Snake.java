package MidExamPreparation;

import java.io.FilterOutputStream;
import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][];
        int snakeRow = -1; // сигурни сме,че ще имаме данни в задачата за тях;
        int snakeCol = -1; // ако не сме сигурни, че ще имаме стойност за тях си им задаваме стойност -1
        int lairFirstRow = -1;
        int lairFirstCol = -1;
        int lairSecondRow = -1;
        int lairSecondCol = -1;

        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            field[i] = row.toCharArray();
            // field[i] = scanner.nextLine().toCharArray();

//            int maybeSnakeColumn = row.indexOf('S');
//            if (maybeSnakeColumn > -1) {
//                snakeRow = i;
//                snakeCol = maybeSnakeColumn;
//            }

            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
                if (field[i][j] == 'B') {
                    if (lairFirstRow == -1) {
                        lairFirstRow = i;
                        lairFirstCol = j;
                    } else {
                        lairSecondRow = i;
                        lairFirstCol = j;
                    }
                }
            }
        }

        int foodEaten = 0;
        //  boolean isSnakeWithInLimits = true;
        // while (isSnakeWithInLimits && foodEaten < 10)
        while (foodEaten < 10) {
            String command = scanner.nextLine();

            field[snakeRow][snakeCol] = '.';
            switch (command) {
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "up":
                    snakeRow--;
                    break;
            }

            if (snakeRow < 0 || snakeRow >= n ||
                    snakeCol < 0 || snakeCol >= n) {
//                isSnakeWithInLimits = false;
//                continue;
                break;
            }

            if (field[snakeRow][snakeCol] == '*') {
                foodEaten++;
            }

            if (snakeRow == lairFirstRow && snakeCol == lairFirstCol) {
                field[snakeRow][snakeCol] = '.';
                snakeRow = lairSecondRow;
                snakeCol = lairSecondCol;
            } else if (snakeRow == lairSecondRow && snakeCol == lairSecondCol) {
                field[snakeRow][snakeCol] = '.';
                snakeRow = lairFirstRow;
                snakeCol = lairFirstCol;
            }

            field[snakeRow][snakeCol] = 'S';
        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
