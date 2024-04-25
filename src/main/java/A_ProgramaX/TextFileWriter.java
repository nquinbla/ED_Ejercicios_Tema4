package A_ProgramaX;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
    private String filePath;

    public TextFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeLine(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
