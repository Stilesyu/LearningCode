package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class MulThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Long> callable = () -> 1L;
        FutureTask<Long> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        Object o = new Object();
        Object o1 = new Object();
        synchronized (o) {
            o1.wait(100);
        }


        System.out.println(thread.getId());
        thread.start();
        System.out.println(futureTask.get());

    }


    @Test
    public void test() {
        System.out.println(toThreadState(1028));
        System.out.println(Integer.toBinaryString(1028));
        System.out.println(Integer.toBinaryString(4));
    }

    public static Thread.State toThreadState(int var0) {
        if ((var0 & 4) != 0) {
            return Thread.State.RUNNABLE;
        } else if ((var0 & 1024) != 0) {
            return Thread.State.BLOCKED;
        } else if ((var0 & 16) != 0) {
            return Thread.State.WAITING;
        } else if ((var0 & 32) != 0) {
            return Thread.State.TIMED_WAITING;
        } else if ((var0 & 2) != 0) {
            return Thread.State.TERMINATED;
        } else {
            return (var0 & 1) == 0 ? Thread.State.NEW : Thread.State.RUNNABLE;
        }
    }


    @Test
    public void test1() throws InterruptedException {
        List<Long> ids = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Object o = new Object();
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                synchronized (o) {
                    if (ids.isEmpty()) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ids.remove(ids.size() - 1);
                }
            });
        }
        Thread.sleep(3000);
        synchronized (o) {
            ids.add(1L);
            o.notifyAll();
        }
        synchronized (this) {
            System.out.println("daf");
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    public synchronized void A() {

    }

    public void B() {
        synchronized (this) {
            Object o = new Object();
        }
    }

    public synchronized static void C() {

    }

    int i = 0;

    public synchronized int increment(){
        return ++i;
    }

    @Test
    public void yieldTest() throws InterruptedException {

       ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i1 = 0; i1 < 5; i1++) {
            for (int i2 = 0; i2 < 1000; i2++) {
                service.execute(() -> increment());
            }
        }
        service.shutdown();
        service.awaitTermination(1,TimeUnit.DAYS);
        System.out.println(i);
    }


}
