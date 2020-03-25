package CarService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FileManager fileManager = FileManager.getInstance();
        String fileName = "C:\\FromZeroToHero\\JavaProjects\\CarServiceSystem\\dataSet.csv";
        //List<String> lines = fileManager.readFile(fileName);

        CarServiceContainer carServiceContainer = new CarServiceContainer();
        carServiceContainer.setRecords(fileName);
        carServiceContainer.display();
    }
}
