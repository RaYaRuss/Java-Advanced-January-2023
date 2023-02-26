package MidExamPreparation;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n -> брой редове == брой колони на матрицата - квадратна по условие
        int n = Integer.parseInt(scanner.nextLine()); // размер на бойното поле

        String[][] matrix = new String[n][n]; // бойното поле
        // пълним матрицата
        fillMatrix(matrix, scanner);
        //2. къде се намира подводницата на бойното поле
        int submarineRow = -1; // текущия ред на поджодницата
        int submarineCol = -1; // текущата колона на подводницата
        int countHits = 0; // колко пъти е уцелена подводницата
        int countCruiser = 0; //брой на круизните кораби кито сме потопили

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (true) {

            // започваме движението:
            matrix[submarineRow][submarineCol] = "-";
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }
            // имаме новата позиция на подводницата
            String submarinePosition = matrix[submarineRow][submarineCol];// на какво място се е преместила подводницата
            if (submarinePosition.equals("-")) {
                matrix[submarineRow][submarineCol] = "S";
            } else if (submarinePosition.equals("*")) {
                matrix[submarineRow][submarineCol] = "S";
                // минава през мина, която избухва;
                countHits++;
                // submarinePosition.equals("-");
                if (countHits == 3) {
                    // подводницата е унищожена
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {
                matrix[submarineRow][submarineCol] = "S";
                countCruiser++;
                if (countCruiser == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }

        // приключва битката и принтираме бойното поле;
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}