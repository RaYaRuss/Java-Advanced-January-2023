package MidExamPreparation;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chestBoard = new String [8][8];
        fillMatrix(chestBoard, scanner);

        String wPosition = findWCoordinates(chestBoard);
        char wRow = wPosition.charAt(0);
        char wCol = wPosition.charAt(1);
        String bPosition = findBCoordinates(chestBoard);
        char bRow = bPosition.charAt(0);
        char bCol = bPosition.charAt(1);

        boolean isHit = false;
        while (wRow != 8 && bRow != 1 && !isHit) {
            if (whiteHits(wRow, wCol, bRow, bCol)) {
                String finalCoordinates = getFinalCoordinates(bRow, bCol);
                System.out.printf("Game over! White capture on %s.%n", finalCoordinates);
                isHit = true;
            }
            wRow++;

            if (blackHits(wRow, wCol, bRow, bCol)) {
                String finalCoordinates = getFinalCoordinates(wRow, wCol);
                System.out.printf("Game over! Black capture on %s.%n", finalCoordinates);
                isHit = true;
            }
            bRow--;
        }
    }

    private static String getFinalCoordinates(char row, char col) {
        StringBuilder sb = new StringBuilder();
        sb.append(row);
        sb.append(col);
        return sb.toString();
    }

    private static boolean whiteHits(char wRow, char wCol, char bRow, char bCol) {
        if (wRow == bRow - 1 && ((wCol + 1 == bCol) || (wCol -1 == bCol))) {
            return true;
        }
        return false;
    }
    private static boolean blackHits(char wRow, char wCol, char bRow, char bCol) {
        if (bRow == wRow + 1 && ((bCol + 1 == wCol) || (bCol -1 == wCol))) {
            return true;
        }
        return false;
    }

    private static String findWCoordinates(String [][] matrix) {
        int wRow = -1;
        int wCol = -1;
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col <= 7; col++) {
                if (matrix[row][col].equals("w"));
                wRow = row;
                wCol = col;

            }
        }
        return null;
    }
    private static String findBCoordinates(String [][] matrix) {
        String bPosition = "";
        for (int row = 8; row <= 1; row--) {
            for (int col = 'a'; col <= 'h'; col++) {
                if (matrix[row][col].equals("b"));
                return bPosition = matrix[row][col];
            }
        }
        return null;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
