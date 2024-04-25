package B_ProgramaListado;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void readFile() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}