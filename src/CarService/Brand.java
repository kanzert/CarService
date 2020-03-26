package CarService;

public enum Brand {
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