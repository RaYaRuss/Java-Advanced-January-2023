package StreamsFilesDirectoriesExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String pathFile = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
           BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
//        // 1vi nachin
//        List<String> allLines = Files.readAllLines(Path.of(pathFile));
//        for (String line : allLines) {
//            writer.write(line.toUpperCase());
//            writer.newLine();
//        }
//        writer.close();

        // 2ri nachin
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
        String line = reader.readLine(); // дада 1вия ред от фаила инпут.тхт
        while (line != null) { // ако редът == null => няма такъв ред
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }
        writer.close();
        }
    }

