package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        String pathWords = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        // в мапа - срещу всяка дума си държим броя на срещанията
        Map<String, Integer> countWordsMap = new HashMap<>();

        for (String line : allLinesWithWords) {
            String[] wordsCurrentRow = line.split("\\s+");
            Arrays.stream(wordsCurrentRow).forEach(word -> {
                countWordsMap.put(word, 0);
            });
        }
        // ще търсим думите в следния текст - файл:
        String pathText = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";

        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String line: allLinesWithText) {
            // премахваме препинателните знаци, остават само думи, разделени с интервал
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String[] words = line.split("\\s+"); // dumite na syotvetniq red
            for (String w : words) {
                if (countWordsMap.containsKey(w)) {
                    countWordsMap.put(w, countWordsMap.get(w) + 1);
                }
            }
        }
        // знаем коя буква по колко пъти я има
        // сортираме по броя на срещанията в низходящ ред
        PrintWriter writer = new PrintWriter("result.txt");
        countWordsMap.entrySet().stream().sorted((e1, el2) ->
                el2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();
    }
}
