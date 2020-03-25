package CarService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Log.setup();
        String fileName = "C:\\FromZeroToHero\\JavaProjects\\CarServiceSystem\\dataSet.csv";
        CarServiceContainer carServiceContainer = new CarServiceContainer();
        carServiceContainer.setRecords(fileName);
        carServiceContainer.display();
    }
}
