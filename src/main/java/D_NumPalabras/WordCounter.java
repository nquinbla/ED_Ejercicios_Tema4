package D_NumPalabras;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordCounter {
    public static int countOccurrences(String filename, String word) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        String[] words = content.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }
}