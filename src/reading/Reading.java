package reading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reading {
    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Error reading file...");
            return "";
        }
    }
}
