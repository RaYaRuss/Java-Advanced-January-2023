package MidExamPreparation;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] directionArr = scanner.nextLine().split(",");
        String[][] bombField = new String[fieldSize][fieldSize];

        fillMatrix(bombField, scanner);
        // String sappersPosition = findSappersPosition(bombField);
        int sappersRow = -1;
        int sappersCol = -1;

        boolean isFound = false;
        for (int i = 0; i < bombField.length; i++) {
            for (int j = 0; j < bombField[i].length; j++) {
                if (bombField[i][j].equals("s")) {
                    sappersRow = i;
                    sappersCol = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        int countBombs = findCountBombs(bombField);

        int bombsFound = 0;

        for (int i = 0; i < directionArr.length; i++) {
            String direction = directionArr[i];
            switch (direction) {
                case "left":
                    if (sappersCol != 0) {
                        sappersCol--;
                    }
                    break;
                case "right":
                    if (sappersCol != bombField.length - 1) {
                        sappersCol++;
                    }
                    break;
                case "up":
                    if (sappersRow != 0) {
                        sappersRow--;
                    }
                    break;
                case "down":
                    if (sappersRow != bombField.length - 1) {
                        sappersRow++;
                    }
                    break;
            }

                    if (bombField[sappersRow][sappersCol].equals("B")) {
                        System.out.println("You found a bomb!");
                        bombsFound++;
                        bombField[sappersRow][sappersCol] = "+";
                        if (countBombs == bombsFound) {
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                    } else if (bombField[sappersRow][sappersCol].equals("e")) {
                        System.out.printf("END! %d bombs left on the field%n", countBombs - bombsFound);
                        return;
                    }
            }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",countBombs - bombsFound, sappersRow, sappersCol);
        }
      

        private static int findCountBombs (String[][]bombField){
            int count = 0;
            for (int i = 0; i < bombField.length; i++) {
                for (int j = 0; j < bombField[i].length; j++) {
                    if (bombField[i][j].equals("B")) {
                        count++;

                    }
                }
            }
            return count;
        }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
