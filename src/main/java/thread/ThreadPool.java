package thread;

import java.util.concurrent.CompletableFuture;

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


}
