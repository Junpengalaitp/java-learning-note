package completableFuture.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsyncMultiBranchExample {
    public static void main(String[] args) {
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

        Function<List<Long>, CompletableFuture<List<User>>> fetchEmails = emails -> {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Supplier<List<User>> supplier = () -> {
                System.out.println("displaying in thread: " + Thread.currentThread().getName());
                return emails.stream().map(User::new).collect(Collectors.toList());
            };
            return CompletableFuture.supplyAsync(supplier, executorService);
        };

        Consumer<List<User>> display = users -> {
            System.out.println("displaying in thread: " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(ids);

        CompletableFuture<List<User>> userCompletableFuture = completableFuture.thenCompose(fetchUsers);
        CompletableFuture<List<User>> emailCompletableFuture = completableFuture.thenCompose(fetchEmails);

        userCompletableFuture.thenAcceptBoth(emailCompletableFuture, (users, emails) -> {
            System.out.println(users.size() + " - " + emails.size());
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
