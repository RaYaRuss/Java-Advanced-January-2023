package MidExamPreparation;

import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsArr = scanner.nextLine().split(",\\s+");
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int pythonLength = 1;

        int rowS = -1;
        int colS = -1;
        int foodCount = findTheFood(matrix);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 's') {
                    rowS = i;
                    colS = j;
                }
            }
            if (rowS != -1 && colS != -1) {
                break;
            }
        }

        for (int i = 0; i < commandsArr.length; i++) {
            String command = commandsArr[i];
            switch (command) {
                case "up":
                    if (rowS > 0) {
                        rowS--;
                    } else {
                        rowS = size - 1;
                    }
                    if (isFood(matrix, rowS, colS)) {
                        pythonLength++;
                        foodCount--;
                    } else if (isEnemy(matrix, rowS, colS)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }

                    break;
                case "down":
                    if (rowS < matrix.length - 1) {
                        rowS++;
                    } else {
                        rowS = 0;
                    }
                    if (isFood(matrix, rowS, colS)) {
                        pythonLength++;
                        foodCount--;
                    } else if (isEnemy(matrix, rowS, colS)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "left":
                    if (colS > 0) {
                        colS--;
                    } else {
                        colS = size - 1;
                    }
                    if (isFood(matrix, rowS, colS)) {
                        pythonLength++;
                        foodCount--;
                    } else if (isEnemy(matrix, rowS, colS)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "right":
                    if (colS < matrix.length - 1) {
                        colS++;
                    } else {
                        colS = 0;
                    }
                    if (isFood(matrix, rowS, colS)) {
                        pythonLength++;
                        foodCount--;
                    } else if (isEnemy(matrix, rowS, colS)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;

            }
        }

        if (foodCount == 0) {
            System.out.println("You win! Final python length is " + pythonLength);
        } else if (foodCount > 0){
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        }

    }


    private static boolean isEnemy(char[][] matrix, int rowS, int colS) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[rowS][colS] == 'e') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isFood(char[][] matrix, int rowS, int colS) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[rowS][colS] == 'f') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();
        }
    }

    private static int findTheFood(char[][] matrix) {
        int foodCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'f') {
                    foodCount++;
                }
            }
        }
        return foodCount;
    }
}
