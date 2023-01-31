package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String pathFile = "/Users/macbookpro/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        // 1vi nachin
//        List<String> allLines = Files.readAllLines(Path.of(pathFile));
//        long sum = 0;
//        for (String line : allLines) {
//            for (char symbol : line.toCharArray()) {
//                sum += symbol;
//            }
//        }
//        System.out.println(sum);

        // 2ri nachin

        // byte => ot -127 do 128
        // sbyte => ot 0 do 256
        byte[] allBytes = Files.readAllBytes(Path.of(pathFile)); // това дава масив от аски кодовете на всички символи във файла

        int sum = 0;
        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                // махаме аски koda за нов ред == 10 и за начало на реда= 13 (carriage return)
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
