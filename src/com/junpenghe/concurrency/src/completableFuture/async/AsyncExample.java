package completableFuture.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsyncExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Supplier<List<Long>> ids = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return List.of(1L, 2L, 3L);
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = userIds -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Supplier<List<User>> supplier = () -> {
                System.out.println("displaying in thread: " + Thread.currentThread().getName());
                return userIds.stream().map(User::new).collect(Collectors.toList());
            };
            return CompletableFuture.supplyAsync(supplier, executorService);
        };

        Consumer<List<User>> display = users -> {
            System.out.println("displaying in thread: " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture
                .supplyAsync(ids)
                .thenComposeAsync(fetchUsers, executorService)
                .thenAcceptAsync(display, executorService);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
