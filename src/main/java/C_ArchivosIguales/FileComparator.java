package C_ArchivosIguales;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del primer archivo:");
        String file1 = scanner.nextLine();

        System.out.println("Introduce el nombre del segundo archivo:");
        String file2 = scanner.nextLine();

        try {
            byte[] file1Content = Files.readAllBytes(Paths.get(file1));
            byte[] file2Content = Files.readAllBytes(Paths.get(file2));

            if (java.util.Arrays.equals(file1Content, file2Content)) {
                System.out.println("Los archivos son iguales.");
            } else {
                System.out.println("Los archivos son diferentes.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer los archivos: " + e.getMessage());
        }
    }
}