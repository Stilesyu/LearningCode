package thread;

import org.junit.Test;


import java.util.concurrent.*;

public class ThreadPool {


    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "方法1";
        });
        future.thenAccept((System.out::println));
        future.exceptionally((throwable -> {
            throwable.printStackTrace();
            return null;
        }));
        System.out.println("main方法执行中");
        Thread.sleep(100000);
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Long value = 0L;
        Future<Long> future = service.submit(() -> {

        }, value);
        System.out.println(future.get());
    }

}
