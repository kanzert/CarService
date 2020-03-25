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

public class CarService implements Comparable<CarService> {
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

    public CarService() {

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

    public void setBrand(String brand) throws BaseAppException {
        if (Brand.contains(brand)) {
            this.brand = brand;
        } else {
            throw new BaseAppException();
        }
    }

    public void setMileage(double mileage) throws BaseAppException {
        if (mileage > 0) {
            this.mileage = mileage;
        } else {
            throw new BaseAppException();
        }
    }

    public void setMechanic(String mechanic) throws BaseAppException {
        String regex = "\\b[a-zA-Z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mechanic);
        if (matcher.matches()) {
            this.mechanic = mechanic;
        } else {
            throw new BaseAppException();
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

    @Override
    public String toString() {
        return "Registration plate : " + registrationPlate + "\n" + "Brand : " + brand + "\n" + "Mileage " + mileage + "\n"
                + "Mechanic : " + mechanic + "\n" + "Cost of repair : " + costOfRepair;
    }

    public static void main(String[] args) throws Exception {
    }

    @Override
    public int compareTo(CarService order) {
        if (this.mileage == order.mileage) {
            return 0;
        } else if (this.mileage < order.mileage) {
            return -1;
        } else {
            return 1;
        }
    }
}
