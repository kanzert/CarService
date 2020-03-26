package CarService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public CarService() {}

    public void setRegistrationPlate(String registrationPlate) throws BaseAppException {
        String regex = "\\b[a-zA-Z]{2}\\d{4}[a-zA-Z]{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(registrationPlate);
        if (matcher.matches()) {
            this.registrationPlate = registrationPlate;
        } else {
            throw new BaseAppException("Wrong registration plate");
        }
    }

    public void setBrand(String brand) throws BaseAppException {
        if (Brand.contains(brand)) {
            this.brand = brand;
        } else {
            throw new BaseAppException("Wrong brand");
        }
    }

    public void setMileage(double mileage) throws BaseAppException {
        if (mileage > 0) {
            this.mileage = mileage;
        } else {
            throw new BaseAppException("Wrong milleage");
        }
    }

    public void setMechanic(String mechanic) throws BaseAppException {
        String regex = "\\b[a-zA-Z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mechanic);
        if (matcher.matches()) {
            this.mechanic = mechanic;
        } else {
            throw new BaseAppException("Wrong mechanic name");
        }
    }

    public void setCostOfRepair(double costOfRepair) throws BaseAppException {
        if (costOfRepair > 0) {
            this.costOfRepair = costOfRepair;
        } else {
            throw new BaseAppException("Wrong cost of repair");
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
