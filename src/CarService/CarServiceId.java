package CarService;

import java.util.concurrent.atomic.AtomicInteger;

public class CarServiceId extends CarService {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;

    public CarServiceId(int id) {
        super();
        this.id = count.incrementAndGet(); ;
    }
}
