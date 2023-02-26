package MidExamPreparation;

import java.util.*;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());

        String[][] fieldOfSparta = new String[numberOfRows][];
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
                    parisEnergy--;
                    fieldOfSparta[enemyRow][enemyCol] = "S";
                    if (rowParis > 0) {
                        rowParis--;

                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                        }
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
                        fieldOfSparta[rowParis][colParis] = "-";
                        printMatrix(fieldOfSparta);
                        return;
                    }

                    break;
                case "down":
                    parisEnergy--;
                    fieldOfSparta[enemyRow][enemyCol] = "S";
                    if (rowParis < fieldOfSparta.length - 1) {
                        rowParis++;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                        }
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
                        fieldOfSparta[rowParis][colParis] = "-";
                        printMatrix(fieldOfSparta);
                        return;
                    }

                    break;
                case "left":
                    parisEnergy--;
                    fieldOfSparta[enemyRow][enemyCol] = "S";
                    if (colParis > 0) {
                        colParis--;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                        }
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
                        fieldOfSparta[rowParis][colParis] = "-";
                        printMatrix(fieldOfSparta);
                        return;
                    }
                    break;
                case "right":
                    parisEnergy--;
                    fieldOfSparta[enemyRow][enemyCol] = "S";
                    if (colParis < fieldOfSparta.length - 1) {
                        colParis++;
                        if (enemyRow == rowParis && enemyCol == colParis) {
                            parisEnergy = parisEnergy - 2;
                        }
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
                        fieldOfSparta[rowParis][colParis] = "-";
                        printMatrix(fieldOfSparta);
                        return;
                    }
                    break;
            }
            commandArr = scanner.nextLine().split("\\s+");
        }
    }
    private static void fillMatrix (String[][]matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
//scanner.nextLine() -> "1 2 3"
//scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static boolean reachedHelen ( int rowP, int colP, int rowH, int colH){
        if (rowP == rowH && colP == colH) {
            return true;
        } else {
            return false;
        }
    }

    private static void printMatrix (String[][]matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
        }

    public static class P01ApocalypsePreparation_Exam {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
            ArrayDeque<Integer> medStack = new ArrayDeque<>();

            Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                    .forEach(textilesQueue::offer);
            Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                    .forEach(medStack::push);
            Map<String, Integer> itemsCreated = new HashMap<>();

            itemsCreated.put("Bandage", 0);
            itemsCreated.put("Patch", 0);
            itemsCreated.put("MedKit", 0);
            int count = 0;

            while (!textilesQueue.isEmpty() && !medStack.isEmpty()) {
                int firstTex = textilesQueue.peek();
                int firstMed = medStack.peek();
                int sum = firstMed + firstTex;

                if (sum == 30) {
                    itemsCreated.put("Patch", itemsCreated.get("Patch") + 1);
                    medStack.pop();
                    textilesQueue.poll();
                    count++;
                } else if (sum == 40) {
                    itemsCreated.put("Bandage", itemsCreated.get("Bandage") + 1);
                    medStack.pop();
                    textilesQueue.poll();
                    count++;
                } else if (sum == 100) {
                    itemsCreated.put("MedKit", itemsCreated.get("MedKit") + 1);
                    medStack.pop();
                    textilesQueue.poll();
                    count++;
                } else if (sum > 100) {
                    itemsCreated.put("MedKit", itemsCreated.get("MedKit") + 1);
                    count++;
                    medStack.pop();
                    textilesQueue.poll();
                    int difference = sum - 100;
                    int current = medStack.pop() + difference;
                    medStack.push(current);
                } else {
                    textilesQueue.poll();
                    medStack.pop();
                    medStack.push(firstMed + 10);
                }

            }


            if (textilesQueue.isEmpty() && medStack.isEmpty()) {
                System.out.println("Textiles and medicaments are both empty.");
            } else if (textilesQueue.isEmpty()) {
                System.out.println("Textiles are empty.");
            } else if (medStack.isEmpty()) {
                System.out.println("Medicaments are empty.");
            }

            if (count > 0) {
                itemsCreated.entrySet().stream().filter(e -> e.getValue() > 0)
                        .sorted((l, r) -> {
                            int result = r.getValue() - l.getValue();
                            if (result == 0) {
                                result = l.getKey().compareTo(r.getKey());
                            }
                             return result;
                        })
                        .forEach(e -> {
                            System.out.println(e.getKey() + " - " + e.getValue());
                        });

            }
            if (!medStack.isEmpty()) {
                System.out.print("Medicaments left: ");
                System.out.println(medStack.toString().replaceAll("[\\[\\]]", ""));
            }
            if (textilesQueue.size() > 0) {
                System.out.print("Textiles left: ");
                System.out.println(textilesQueue.toString().replaceAll("[\\[\\]]", ""));
            }

            //         // this.data.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
            //        //        return sb.toString();
            //
            ////        List<Child> collect = registry.stream().sorted((ch1, ch2) -> ch2.getAge() - ch1.getAge())
            ////                .sorted((ch1, ch2) -> ch1.getLastName().compareTo(ch2.getLastName()))
            ////                .sorted((ch1, ch2) -> ch1.getFirstName().compareTo(ch2.getFirstName())).collect(Collectors.toList());
            ////        sb.append(collect);
            ////        List<String> collect = this.registry.stream().map(Child::toString).collect(Collectors.toList());
            ////        sb.append(collect).append(System.lineSeparator());
        }
    }
}

