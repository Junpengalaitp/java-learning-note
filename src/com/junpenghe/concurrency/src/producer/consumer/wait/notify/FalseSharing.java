package producer.consumer.wait.notify;


import sun.misc.Contended;

public class FalseSharing {
    public static final int NUM_THREADS_MAX = 6;
    public static final long ITERATIONS = 50000000L;

    private static final VolatileLongPadded[] paddedLongs;
    private static final VolatileLongUnPadded[] unPaddedLongs;

    @Contended
    private static class VolatileLongPadded {
//        public long q1, q2, q3;
        public volatile long value = 0L;
//        public long q11, q12;
    }

    private static class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLongs.length; i++) {
            paddedLongs[i]= new VolatileLongPadded();
        }
        unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for (int i = 0; i < unPaddedLongs.length; i++) {
            unPaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    private static void runBenchmark() throws InterruptedException {
        long begin, end;
        for (int n = 1; n <= NUM_THREADS_MAX; n++) {
            Thread[] threads = new Thread[n];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }

            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();

            System.out.printf("  Padded threads %d - T = %dms\n", n, end - begin);

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createUnPaddedRunnable(j));
            }

            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();

            System.out.printf("UnPadded threads %d - T = %dms\n", n, end - begin);
        }
    }

    private static Runnable createUnPaddedRunnable(int j) {
        return () -> {
            long i = ITERATIONS + 1;
            while (--i != 0) {
                unPaddedLongs[j].value = i;
            }
        };
    }

    private static Runnable createPaddedRunnable(int j) {
        return () -> {
            long i = ITERATIONS + 1;
            while (--i != 0) {
                paddedLongs[j].value = i;
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        runBenchmark();
    }
}
