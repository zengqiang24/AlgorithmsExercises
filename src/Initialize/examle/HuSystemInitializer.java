package Initialize.examle;

import Initialize.Initializer;

import java.util.ArrayList;
import java.util.List;

public class HuSystemInitializer implements Initializer<HuSystem> {
    @Override
    public HuSystem create() {
        HuSystem huSystem = new HuSystem();
        huSystem.init();
        return huSystem;
    }

    @Override
    public List<Class<? extends Initializer>> dependencies() {
        ArrayList<Class<? extends Initializer>> objects = new ArrayList<>();
        objects.add(LoggerInitializer.class);
        return objects;
    }
}
