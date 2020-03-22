package CarService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Brand {
    MERCEDES("Mercedes"),
    MAZDA("Mazda"),
    NISSAN("Nissan"),
    TOYOTA("Toyota"),
    FERRARI("Ferrari"),
    PORSCHE("Porsche"),
    SUBARU("Subaru"),
    LEXUS("Lexus"),
    CHEVROLET("Chevrolet"),
    FORD("Ford"),
    SKODA("Skoda"),
    HYUNDAI("Hyundai");

    public final String brand;

    Brand(String brand) {
        this.brand = brand;
    }
}

public class CarService {
    private String registrationPlate;
    private Brand brand;
    private double mileage;
    private String mechanic;
    private double costOfRepair;

    public CarService(String registrationPlate, Brand brand, double mileage, String mechanic, double costOfRepair) throws Exception {
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

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public void setCostOfRepair(double costOfRepair) {
        this.costOfRepair = costOfRepair;
    }


    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public Brand getBrand() {
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

    public static void main(String[] args) {
        System.out.println("lololo");
    }
}
