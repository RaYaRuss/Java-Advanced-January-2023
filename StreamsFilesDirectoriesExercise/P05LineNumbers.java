package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("output_line_numbers.txt");
        int lineNumber = 1;

        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }

        writer.close(); // spirame da pishem vyv faila i failyt se zapazva i zatvarq
    }
}
