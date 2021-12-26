package Initialize;

import java.util.List;

public interface Initializer<T> {
    T create();
    List<Class<? extends Initializer>> dependencies();
}
