package lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class LockEffectiveTest {

    private Long i = 0L;

    @Test
    public void incrementMulThreadLockTest() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = incrementMulThreadLock();
        executorService.shutdown();
        boolean isSuccess = executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(isSuccess);
        System.out.println("speed:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void incrementNotLockTest(){
        long startTime = System.currentTimeMillis();
        incrementNotLock();
        System.out.println("speed:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void incrementSingleThreadLockTest(){
        long startTime = System.currentTimeMillis();
        incrementSingleThreadLock();
        System.out.println("speed:" + (System.currentTimeMillis() - startTime));
    }



    private static void incrementNotLock() {
        int i = 0;
        while (i < 1000000000L) {
            i++;
        }
    }


    private void incrementSingleThreadLock() {
        while (i < 1000000000L) {
            increment();
        }
    }


    private ExecutorService incrementMulThreadLock() {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            while (i < 1000000000L) {
                increment();
            }
        });
        System.out.println("线程池初始化花费："+(System.currentTimeMillis()-start));
        return executor;
    }


    private synchronized void increment() {
        i++;
    }


}

