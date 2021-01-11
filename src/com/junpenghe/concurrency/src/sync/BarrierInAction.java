package sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class BarrierInAction {
    public static void main(String[] args) {
        class Friend implements Callable<String> {
            private final CyclicBarrier cyclicBarrier;

            public Friend(CyclicBarrier cyclicBarrier) {
                this.cyclicBarrier = cyclicBarrier;
            }

            @Override
            public String call() throws Exception {
                Random random = new Random();
                Thread.sleep(random.nextInt(20) * 100 + 100);
                System.out.println("I just arrived, waiting for the others");

                cyclicBarrier.await(5, TimeUnit.SECONDS);

                System.out.println("Let's go to the cinema!");
                return "ok";
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("Barrier opening"));
        List<Future<String>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                Friend friend = new Friend(cyclicBarrier);
                futures.add(executorService.submit(friend));
            }

            futures.forEach(
                    future -> {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            System.out.println(e.getMessage());
                        }
                    }
            );
        } finally {
            executorService.shutdown();
        }
    }
}
