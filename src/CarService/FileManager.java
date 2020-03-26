package CarService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private static FileManager instance;

    private FileManager() {}

    public static FileManager getInstance() { // #3
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}
