package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        String pathFile = "/Users/macbookpro/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathFile));

        // 1vi nachin
            for (String line : allLines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += (int) symbol;
            }
            System.out.println(sum);
        }

        // 2ri nachin
//        allLines.forEach(line -> {
//        int sum = 0;
//        for (char symbol : line.toCharArray()) {
//            sum += (int) symbol;
//        }
//        System.out.println(sum);
//                });
    }
}
