package executor.pattern;

import java.util.concurrent.*;

public class PlayingWithCallableAndFutures {
    public static void main(String[] args) throws Exception{

        Callable<String> task = () -> {
            Thread.sleep(300);
            return String.format("I am in thread %s", Thread.currentThread().getName());
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                Future<String> future = executorService.submit(task);
                System.out.printf("I get: %s \n", future.get(100, TimeUnit.MILLISECONDS));
            }
        } finally {
            executorService.shutdown();
        }
    }
}
