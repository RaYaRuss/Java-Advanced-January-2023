package StreamsFilesDirectoriesExercise;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathFile = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathFile));
        int countVowels = 0;
        int countOtherSymbols = 0;
        int countPunctuations = 0;

        FileWriter fileWriter = new FileWriter("output_count.txt");

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                    if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i'
                    || currentSymbol == 'o' || currentSymbol == 'u') {
                        countVowels++;
                    } else if (currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.'
                    || currentSymbol == '?') {
                        countPunctuations++;
                    } else {
                        if (currentSymbol != ' ') {
                            countOtherSymbols++;
                        }
                    }
                }
            }
        fileWriter.write(String.format("Vowels: %d%n", countVowels));
        fileWriter.write(String.format("Other symbols: %d%n", countOtherSymbols));
        fileWriter.write(String.format("Punctuation: %d%n", countPunctuations));

        fileWriter.close();
        }
    }

