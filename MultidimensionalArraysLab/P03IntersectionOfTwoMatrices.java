package MultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split(" ");

            for (int col = 0; col < columns; col++) {
                firstMatrix[row][col] =(columnData[col].charAt(0));
            }
        }

        char[][] secondMatrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split(" ");

            for (int col = 0; col < columns; col++) {
                secondMatrix[row][col] = columnData[col].charAt(0);
            }
        }

        char[][] outputMatrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    outputMatrix[i][j] = '*';
                } else {
                    outputMatrix[i][j] = firstMatrix[i][j];
                }
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
