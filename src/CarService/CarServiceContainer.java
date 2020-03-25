package CarService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CarServiceContainer {
    private List<CarService> records = new ArrayList<>();
    String[] carServiceHeaders = {"Registration plate", "Brand", "Mileage", "Mechanic", "Cost of repair"};
    public void setRecords(String fileName) {
        try {
            List<String> lines = FileManager.getInstance().readFile(fileName);
            String[] headersInFile = lines.get(0).split(";");

            if (carServiceHeaders.length != headersInFile.length) {
                throw new Exception();
            }

            for (int i = 0; i < carServiceHeaders.length; i++) {
                if (!carServiceHeaders[i].equals(headersInFile[i])) {
                    throw new Exception();
                }
            }

            String[] values;

            for (int i = 1; i < lines.size(); i++) {
                values = lines.get(i).split(";");
                CarService record = new CarService();
                record.setRegistrationPlate(values[0]);
                record.setBrand(values[1]);
                record.setMileage(Double.parseDouble(values[2]));
                record.setMechanic(values[3]);
                record.setCostOfRepair(Double.parseDouble(values[4]));
                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {
        for (CarService carService : records) {
            System.out.println(carService);
        }
    }
}
