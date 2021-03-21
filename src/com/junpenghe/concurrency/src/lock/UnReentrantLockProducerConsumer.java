package lock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class UnReentrantLockProducerConsumer {
    private final static Lock lock = new UnReentrantLock();
    private final static Condition isEmpty = lock.newCondition();
    private final static Condition isFull = lock.newCondition();

    private final static Queue<String> queue = new LinkedBlockingDeque<>();
    private final static int queueSize = 10;

    public static void main(String[] args) throws Exception {
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                while (queueSize == queue.size()) {
                    isFull.await();
                }
                queue.add("element");
                isEmpty.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
           lock.lock();
           try {
               while (queue.isEmpty()) {
                   isEmpty.await();
               }
               queue.poll();
               isFull.signalAll();
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }
        });

        producer.start();
        consumer.start();
    }
}
