package MultidimensionalArraysLab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String[] columnData = scanner.nextLine().split(" ");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (columnData[col].charAt(0));
            }
        }

        int countQ = 0;
        boolean isReal = true;
        int realRow = 0;
        int realCol = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = matrix[i][j];
                if (current == 'q') {
                    realRow = i;
                    realCol = j;
                    countQ++;

                    for (char elemRow : matrix[i]) {
                        if (elemRow == 'q') {
                            countQ++;
                            if (countQ > 2) {
                                isReal = false;
                                realRow = 0;
                                realCol = 0;
                                countQ = 0;
                                break;
                            }
                        }
                        break;
                    }
                    if (!isReal) {
                        continue;
                    }
                    for (char elemCol : matrix[j]) {
                        if (elemCol == 'q') {
                            countQ++;
                            if (countQ > 2) {
                                isReal = false;
                                realRow = 0;
                                realCol = 0;
                                countQ = 0;
                                break;
                            }
                        }
                    }
                    for (int diagonalRow = i, diagonalCol = j; diagonalRow >= 0; diagonalRow--,diagonalCol--) {
                        if (current == 'q') {
                            countQ++;
                            if (countQ > 2) {
                                isReal = false;
                                realRow = 0;
                                realCol = 0;
                                countQ = 0;
                                break;
                            }
                        }
                    }
                    for (int diagonalRow = i, diagonalCol = j; diagonalRow <= 0; diagonalRow++,diagonalCol++) {
                        if (current == 'q') {
                            countQ++;
                            if (countQ > 2) {
                                isReal = false;
                                realRow = 0;
                                realCol = 0;
                                countQ = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(realRow + " " + realCol);
    }
}