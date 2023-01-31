package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class P07MergeTwoFiles {
    // List za ediniq fail i List za vtoriw fail i v treti gi sybirame kato pyrvo obhojdame pyrwiq posle vroriq
// v 8.46 dolu gore predi 6ta zadacha
    public static void main(String[] args) throws IOException {

        String pathInput1 = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String pathInput2 = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        List<String> allLinesWithInput1 = Files.readAllLines(Path.of(pathInput1));
        List<String> allLinesWithInput2 = Files.readAllLines(Path.of(pathInput2));

        List<String> outputList = new ArrayList<>();

        for (String line : allLinesWithInput1) {
            outputList.add(line);
        }
        for (String l : allLinesWithInput2) {
            outputList.add(l);
        }
        for (String line : outputList) {
            System.out.println(line);
        }
    }
}
