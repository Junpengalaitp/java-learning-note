package producer.consumer.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProducerConsumerWithLocks {

    public static void main(String[] args) throws Exception {
        List<Integer> buffer = new ArrayList<>();
        int size = 50;
        Lock lock = new ReentrantLock();
        Condition isEmpty = lock.newCondition();
        Condition isFull = lock.newCondition();

        class Consumer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                while (count++ < size) {
                    lock.lock();
                    try {
                        while (buffer.isEmpty()) {
                            // wait
                            if (!isEmpty.await(10, TimeUnit.MILLISECONDS)) {
                                throw new TimeoutException("Consumer time out");
                            }
                        }
                        buffer.remove(buffer.size() - 1);
                        isFull.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }

                return "Consumed " + (count - 1);
            }
        }

        class Producer implements Callable<String> {

            @Override
            public String call() throws Exception {
                int count = 0;
                while (count++ < size) {
                    lock.lock();
                    try {
                        int i = 10 / 0;
                        while (buffer.size() >= size) {
                            // wait
                            isFull.await();
                        }
                        buffer.add(1);
                        isEmpty.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }

                return "Produced " + (count - 1);
            }
        }

        List<Producer> producers = IntStream.range(0, 4)
                .mapToObj(i -> new Producer())
                .collect(Collectors.toList());

        List<Consumer> consumers = IntStream.range(0, 4)
                .mapToObj(i -> new Consumer())
                .collect(Collectors.toList());

        System.out.println("Producers and Consumers launched");

        List<Callable<String>> producerAndConsumers = Stream.concat(producers.stream(), consumers.stream()).collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        try {
            List<Future<String>> futures = executorService.invokeAll(producerAndConsumers);

            futures.forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            });
        } finally {
            executorService.shutdown();
            System.out.println("executorService shutdown");
        }
    }
}
