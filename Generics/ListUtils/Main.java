package Generics.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(45);
        ints.add(81);
        ints.add(56);
        System.out.println((ListUtils.getMax(ints)));
    }
}
