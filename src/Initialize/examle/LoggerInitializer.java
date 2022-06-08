package Initialize.examle;

import Initialize.AppInitializer;
import Initialize.Initializer;

import java.util.ArrayList;
import java.util.List;

public class LoggerInitializer implements Initializer<Logger> {

    @Override
    public Logger create() {
        Logger logger = new Logger();
        logger.init();
        return logger;
    }

    @Override
    public List<Class<? extends Initializer>> dependencies() {
        return new ArrayList<>();
    }
}
