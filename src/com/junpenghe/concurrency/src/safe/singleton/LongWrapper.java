package safe.singleton;

public class LongWrapper {
    private final Object key = new Object();
    private volatile long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getL() {
        synchronized (key) {
            return l;
        }
    }

    public void incrementValue() {
        synchronized (key) {
            l++;
        }
    }
}
