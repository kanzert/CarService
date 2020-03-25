package CarService;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public static Logger logger = Logger.getLogger("CarService");
    private static FileHandler fh;

    static {
        try {
            Date date = new Date(System.currentTimeMillis());
            fh = new FileHandler("CarService.log", 0, 1, false);
        } catch (IOException | SecurityException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    static void setup() {
        Log.logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
