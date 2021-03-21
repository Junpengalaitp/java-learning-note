package lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportExp {
    public static void main(String[] args) throws InterruptedException {
        unParkExample3();
    }

    private static void parkExample() {
        System.out.println("park starts");
        LockSupport.park();
        System.out.println("park end");
    }

    private static void unParkExample() {
        System.out.println("park starts");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("park end");
    }

    private static void unParkExample2() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("child thread park begins");
            LockSupport.park();
            System.out.println("child thread end park");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread start unpark");
        LockSupport.unpark(thread);
    }

    private static void unParkExample3() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("child thread park begins");
            while (!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
            }
            System.out.println("child thread end park");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread start unpark");
        thread.interrupt();
    }
}
