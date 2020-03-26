package CarService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class CarServiceContainer {
    private List<CarService> records = new ArrayList<>();
    String fileName;
    final String[] carServiceHeaders = {"Registration plate", "Brand", "Mileage", "Mechanic", "Cost of repair"};
    public void setRecords(String fileName) throws BaseAppException {
        try {
            List<String> lines = FileManager.getInstance().readFile(fileName);
            this.fileName = fileName;
            String[] headersInFile = lines.get(0).split(";");

            if (carServiceHeaders.length != headersInFile.length) {
                throw new BaseAppException("Headers numbers doesn't match.");
            }

            for (int i = 0; i < carServiceHeaders.length; i++) {
                if (!carServiceHeaders[i].equals(headersInFile[i])) {
                    throw new BaseAppException("Headers doesn't match");
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
            throw new BaseAppException(e.getMessage());
        }
    }

    public void serializeJSON() throws BaseAppException {
        if (this.records.isEmpty()) {
            throw new BaseAppException("There's nothing to serialize");
        }
        try {
            String[] split = fileName.split("\\.");
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName != null ? split[0] + ".json" : "output.json"));
            Collections.sort(records);
            writer.write("[");
            writer.write("\n");
            int counter = 0;
            for(CarService service : records) {

                writer.write("  {\n");
                writer.write("    \"registrationPlate: \"" + service.getRegistrationPlate() + ",\n");
                writer.write("    \"brand: \"" + service.getBrand() + ",\n");
                writer.write("    \"mileage: \"" + service.getMileage() + ",\n");
                writer.write("    \"mechanic: \"" + service.getMechanic() + ",\n");
                writer.write("    \"costOfRepair: \"" + service.getCostOfRepair() + "\n");
                if (counter != records.size() - 1) {
                    writer.write("  },\n");
                } else {
                    writer.write("  }");
                }
                counter ++;
            }
            writer.write("\n]");
            writer.close();
        } catch (IOException e) {
            throw new BaseAppException(e.getMessage());
        }
    }

    public void display() {
        for (CarService carService : records) {
            System.out.println(carService);
        }
    }
}
