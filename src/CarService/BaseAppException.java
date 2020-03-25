package CarService;

import java.util.Date;
import java.util.logging.Level;

public class BaseAppException extends Exception {

    public BaseAppException(String message) {
        super(message);
    }

    public void log(boolean handled) {
        Date date = new Date(System.currentTimeMillis());
        StackTraceElement handledTrace = Thread.currentThread().getStackTrace()[2];
        String text = String.format("Error: %s(%s:%s): %s",
                getStackTrace()[0].getMethodName(),
                getStackTrace()[0].getFileName(),
                getStackTrace()[0].getLineNumber(),
                getMessage());

        if(handled)
            text = text + String.format(" HANDLED %s(%s:%s)\n",
                    handledTrace.getMethodName(), handledTrace.getFileName(),
                    handledTrace.getLineNumber());
        else
            text = text + "NOT HANDLED\n";

        Log.logger.log(Level.WARNING, text);
    }

    public void log() {
        log(false);
    }
}
