package Generics.GenaricScale;

public class Main {

    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(85, 598);
        System.out.println(scale.getHeavier());
    }
}
