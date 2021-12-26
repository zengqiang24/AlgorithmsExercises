package Initialize.examle;

import Initialize.AppInitializer;
import Initialize.Initializer;

import java.util.ArrayList;
import java.util.List;

public class MusicManagerInitializer implements Initializer<MusicManager> {

    @Override
    public MusicManager create() {
        MusicManager musicManager = new MusicManager();
        musicManager.init();
        return musicManager;
    }

    @Override
    public List<Class<? extends Initializer>> dependencies() {
        ArrayList<Class<? extends Initializer>> arrayList = new ArrayList<>();
        arrayList.add(LoggerInitializer.class);
        arrayList.add(HuSystemInitializer.class);
        return arrayList;
    }
}
