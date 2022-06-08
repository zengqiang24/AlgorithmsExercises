package Initialize;

import Initialize.examle.MusicManagerInitializer;

public class Application {
    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer();
        appInitializer.setUpInitializers(MusicManagerInitializer.class);
        try {
            appInitializer.discoverAndInitialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
