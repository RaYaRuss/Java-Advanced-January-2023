package SetsAndMapsAdvancedLab;

import java.util.*;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split(" ");
        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            deckOne.add(current);
        }

        String[] inputTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            deckTwo.add(current);
        }
//        Iterator<Integer> iteratorOne = deckOne.iterator();
//        Iterator<Integer> iteratorTwo = deckTwo.iterator();

        for (int step = 0; step < 50; step++) {

            if (deckOne.isEmpty()) {
                break;
            } else if ( deckTwo.isEmpty()) {
                break;
            }
            Integer fighterOne = deckOne.iterator().next(); // == getTopElement(deckOne); metod
            Integer fighterTwo = deckTwo.iterator().next();

            deckOne.remove(fighterOne);
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterTwo > fighterOne) {
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }
        }
        if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else if (deckOne.size() > deckTwo.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }

//    private static Integer getTopElement(Set<Integer> set) {
//        return set.iterator().next();
        // vtori variant
//        for (Integer item : set) {
//            return item;
//        }
    //}
}
