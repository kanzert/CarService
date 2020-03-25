package CarService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Brand {
    ASTON_MARTIN("aston martin"),
    CHEVROLET("chevrolet"),
    FERRARI("ferrari"),
    FORD("ford"),
    HYUNDAI("hyundai"),
    LEXUS("lexus"),
    MAZDA("mazda"),
    MERCEDES("mercedes"),
    NISSAN("nissan"),
    PORSCHE("porsche"),
    SKODA("skoda"),
    SUBARU("subaru"),
    TOYOTA("toyota");

    String brand;
    Brand(String brand) {
        this.brand = brand;
    }

    public static boolean contains(String test) {
        for (Brand c : Brand.values()) {
            if (c.brand.equals(test.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

public class CarService {
    private String registrationPlate;
    private String brand;
    private double mileage;
    private String mechanic;
    private double costOfRepair;

    public CarService(String registrationPlate, String brand, double mileage, String mechanic, double costOfRepair) throws Exception {
        setRegistrationPlate(registrationPlate);
        setBrand(brand);
        setMileage(mileage);
        setMechanic(mechanic);
        setCostOfRepair(costOfRepair);
    }

    public void setRegistrationPlate(String registrationPlate) throws Exception {
        String regex = "\\b[a-zA-Z]{2}\\d{4}[a-zA-Z]{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(registrationPlate);
        if (matcher.matches()) {
            this.registrationPlate = registrationPlate;
        } else {
            throw new Exception();
        }
    }

    public void setBrand(String brand) throws Exception {
        if (Brand.contains(brand)) {
            this.brand = brand;
        } else {
            throw new Exception();
        }
    }

    public void setMileage(double mileage) throws Exception {
        if (mileage > 0) {
            this.mileage = mileage;
        } else {
            throw new Exception();
        }
    }

    public void setMechanic(String mechanic) throws Exception {
        String regex = "\\b[a-zA-Z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mechanic);
        if (matcher.matches()) {
            this.mechanic = mechanic;
        } else {
            throw new Exception();
        }
    }

    public void setCostOfRepair(double costOfRepair) throws Exception {
        if (costOfRepair > 0) {
            this.costOfRepair = costOfRepair;
        } else {
            throw new Exception();
        }
    }


    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public String getBrand() {
        return brand;
    }

    public double getMileage() {
        return mileage;
    }

    public String getMechanic() {
        return mechanic;
    }

    public double getCostOfRepair() {
        return costOfRepair;
    }

    public static void main(String[] args) throws Exception {
    }
}
