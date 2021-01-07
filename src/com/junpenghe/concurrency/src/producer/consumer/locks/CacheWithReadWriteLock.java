package producer.consumer.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLock {
    private final Map<Long, String> cache = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public String put(Long key, String value) {
        writeLock.lock();
        try {
            return cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(Long key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        CacheWithReadWriteLock cache = new CacheWithReadWriteLock();

        class Producer implements Callable<String> {
            private final Random random = new Random();

            @Override
            public String call() throws Exception {
                while (true) {
                    long key = random.nextInt(1000);
                    cache.put(key, Long.toString(key));
                    if (cache.get(key) == null) {
                        System.out.println("Key: " + key + " has not been put in the map");
                    }
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 4; i++) {
                executorService.submit(new Producer());
            }
        } finally {
            executorService.shutdown();
        }
    }
}
