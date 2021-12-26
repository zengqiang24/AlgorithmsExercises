package Initialize;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppInitializer {
    private final  Set<Class<?>> initializing = new HashSet<>();
    private final Map<Class<? extends Initializer>, Object> initialized = new HashMap<>();
    private Class<? extends Initializer> tailInitializer;

    public void setUpInitializers(Class<? extends Initializer> tailInitializer) {
        this.tailInitializer = tailInitializer;
    }

    void discoverAndInitialize() throws Exception {
        doInitialize(tailInitializer, new HashSet<>());
    }

    /**
     * 进行拓扑排序，此处使用的是dfs，深度遍历。
     *
     * @param component
     * @param initializing
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> T doInitialize(Class<? extends Initializer> component, Set<Class<?>> initializing) throws Exception {
        T result = null;
        try {
            if (initializing.contains(component)) {
                throw new Exception("Cannot init this initializer. there has a loop in grahf");
            }
            if (initialized.containsKey(component)) {
                return (T) initialized.get(component);
            }
            Initializer<T> initializer = component.newInstance();
            initializing.add(component);
            if (initializer.dependencies().size() != 0) {
                for (Class<? extends Initializer> dependency : initializer.dependencies()) {
                    doInitialize(dependency, initializing);//先对其领接的依赖模块进行初始化
                }
            }
            initializing.remove(component);
            result = initializer.create();
            initialized.put(component, result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ExecutorService getExecutor(){
        return Executors.newFixedThreadPool(5);
    }
}
