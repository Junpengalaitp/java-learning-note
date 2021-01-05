package safe.singleton;

public class DoubleCheckingSingleton {
    // have to use 'volatile' keyword for read sync
    private static volatile DoubleCheckingSingleton instance;

    private static final Object lock = new Object();

    private DoubleCheckingSingleton() {}

    public static synchronized DoubleCheckingSingleton getInstance() {
        if (instance != null) {
            return instance;
        }
        // write sync
        synchronized (lock) {
            instance = new DoubleCheckingSingleton();
        }
        return instance;
    }
}
