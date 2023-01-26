package SetAndMapsAdvancedExercises;


import java.util.*;

import static java.lang.Character.isDigit;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> namesAndCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String cardsLine = input.split(": ")[1];
            String[] cards = cardsLine.split(", ");
            List<String> cardsList = Arrays.asList(cards);

            if (!name.contains(":")) {
                namesAndCards.putIfAbsent(name, new HashSet<>());

                namesAndCards.get(name).addAll(cardsList);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : namesAndCards.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            int valuePlayer = getPower(entry);
            System.out.print(valuePlayer);
            System.out.println();

            }
        }
        private static int getPower(Map.Entry<String, Set<String>> entry) {
        int value = 0;
        for (String card : entry.getValue()) {

            String type = card.substring(card.length() - 1);
            String power = (card.substring(0, card.length() - 1));
            int multiplyingNum = getMultiplyingNum(type);

            if (isDigit(power.charAt(0))) {
                value += Integer.parseInt(power) * multiplyingNum;
            } else {
                switch (power) {
                    case "J":
                        value += 11 * multiplyingNum;
                        break;
                    case "Q":
                        value += 12 * multiplyingNum;
                        break;
                    case "K":
                        value += 13 * multiplyingNum;
                        break;
                    case "A":
                        value += 14 * multiplyingNum;
                        break;
                }
            }
        }
        return value;
    }
    private static int getMultiplyingNum(String type) {

        int multiplyingNum = 0;
        switch (type) {
            case "C":
                multiplyingNum = 1;
                break;
            case "D":
                multiplyingNum = 2;
                break;
            case "H":
                multiplyingNum = 3;
                break;
            case "S":
                multiplyingNum = 4;
                break;
        }
        return multiplyingNum;
    }
}
