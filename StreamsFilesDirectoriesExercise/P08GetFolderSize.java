package StreamsFilesDirectoriesExercise;

import java.io.File;
import java.util.Scanner;

public class P08GetFolderSize {
    public static void main(String[] args) {
        String path = "/Users/macbookpro/Desktop/JavaAdvancedJan2023/src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(path);

        File[] allFilesInFolder = folder.listFiles(); // vzimame vsichki failove v papkata

        int folderSize = 0; // razmeryt na papkata = suma ot vsichki failove vytre v neq
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);

    }
}
