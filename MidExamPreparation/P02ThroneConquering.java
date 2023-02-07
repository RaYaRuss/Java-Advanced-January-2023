package MidExamPreparation;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());

        String [][] fieldOfSparta = new String[numberOfRows][];
        fillMatrix(fieldOfSparta, scanner);

        int rowParis = -1;
        int colParis = -1;
        int rowHelen = -1;
        int colHelen = -1;

        boolean isFoundHelen = false;
        boolean isFoundParis = false;
        for (int i = 0; i < fieldOfSparta.length; i++) {
            for (int j = 0; j < fieldOfSparta[i].length; j++) {
                if (fieldOfSparta[i][j].equals("P")) {
                    rowParis = i;
                    colParis = j;
                    isFoundParis = true;
                } else if (fieldOfSparta[i][j].equals("H")) {
                    rowHelen = i;
                    colHelen = j;
                    isFoundHelen = true;
                }
            }
            if (isFoundHelen && isFoundParis) {
                break;
            }
        }

        fieldOfSparta[rowParis][colParis] = "-";

        String[] commandArr = scanner.nextLine().split("\\s+");

        while (true) {
            String direction = commandArr[0];
            int enemyRow = Integer.parseInt(commandArr[1]);
            int enemyCol = Integer.parseInt(commandArr[2]);

            switch (direction) {
                case "up":
                    if (rowParis != 0) {
                        rowParis--;
                        parisEnergy--;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                            fieldOfSparta[enemyRow][enemyCol] = "S";
                            if (parisEnergy <= 0) {
                                fieldOfSparta[rowParis][colParis] = "X";
                                System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
                                printMatrix(fieldOfSparta);
                                return;
                            } else {
                                fieldOfSparta[rowParis][colParis] = "-";
                            }
                    }
                        if (reachedHelen(rowParis, colParis, rowHelen, colHelen)) {
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                            printMatrix(fieldOfSparta);
                            return;
                        }
                    } else {
                        parisEnergy--;
                    }
                    break;
                case "down":
                    if (rowParis != fieldOfSparta.length - 1) {
                        rowParis++;
                        parisEnergy--;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                            fieldOfSparta[enemyRow][enemyCol] = "S";
                            if (parisEnergy <= 0) {
                                fieldOfSparta[rowParis][colParis] = "X";
                                System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
                                printMatrix(fieldOfSparta);
                                return;
                            } else {
                                fieldOfSparta[rowParis][colParis] = "-";
                            }
                        }
                        if (reachedHelen(rowParis, colParis, rowHelen, colHelen)) {
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                            printMatrix(fieldOfSparta);
                            return;
                        }
                    } else {
                        parisEnergy--;
                    }
                    break;
                case "left":
                    if (colParis != 0) {
                        colParis--;
                        parisEnergy--;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                            fieldOfSparta[enemyRow][enemyCol] = "S";
                            if (parisEnergy <= 0) {
                                fieldOfSparta[rowParis][colParis] = "X";
                                System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
                                printMatrix(fieldOfSparta);
                                return;
                            } else {
                                fieldOfSparta[rowParis][colParis] = "-";
                            }
                        }
                        if (reachedHelen(rowParis, colParis, rowHelen, colHelen)) {
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                            printMatrix(fieldOfSparta);
                            return;
                        }
                    } else {
                        parisEnergy--;
                    }
                    break;
                case "right":
                    if (colParis != fieldOfSparta.length - 1) {
                        colParis++;
                        parisEnergy--;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                            fieldOfSparta[enemyRow][enemyCol] = "S";
                            if (parisEnergy <= 0) {
                                fieldOfSparta[rowParis][colParis] = "X";
                                System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
                                printMatrix(fieldOfSparta);
                                return;
                            } else {
                                fieldOfSparta[rowParis][colParis] = "-";
                            }
                        }
                        if (reachedHelen(rowParis, colParis, rowHelen, colHelen)) {
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                            printMatrix(fieldOfSparta);
                        return;
                        }
                    } else {
                        parisEnergy--;
                    }
                    break;
            }
            commandArr = scanner.nextLine().split("\\s+");
        }

        }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
//scanner.nextLine() -> "1 2 3"
//scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static boolean reachedHelen(int rowP, int colP, int rowH, int colH) {
        if (rowP == rowH && colP == colH) {
            return true;
        } else {
            return false;
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

}
