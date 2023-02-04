package Generics.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(100);
        System.out.println(jar.remove());
    }
}