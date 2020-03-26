package CarService;

public class Main {
    public static void main(String[] args) {
        Log.setup();
        CarServiceContainer carServiceContainer = new CarServiceContainer();
        try {
            carServiceContainer.setRecords("dataSet.csv");
            carServiceContainer.serializeJSON();
        } catch (BaseAppException e) {
            e.log(true);
        }
    }
}
