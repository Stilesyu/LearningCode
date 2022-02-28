import sun.misc.Contended;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CacheLineEffect {

    private static final Padding[] array = new Padding[4];


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Padding();
        }
        ExecutorService service = Executors.newFixedThreadPool(6);
        long start = System.nanoTime();
        for (int i = 0; i < 4; i++) {
            AtomicInteger integer = new AtomicInteger(i);
            service.execute(() -> {
                int index = integer.get();
                for (long j = 0; j < 10000000; j++) {
                    array[index].value = j;
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("speed:"+(System.nanoTime()-start));
    }


    static class NoPadding {
        public volatile long value = 0L;
    }

    static class Padding {
        volatile long p1, p2, p3, p4, p5, p6, p7;
        volatile long p11, p12, p13, p14, p15, p16, p17 ,p18;
        public volatile long value = 0L;
        volatile long p21, p22, p23, p24, p25, p26, p27;
        volatile long p31, p32, p33, p34, p35, p36, p37 ,p38;
    }


    static class PaddingWithContended {
        @Contended
        public volatile long value = 0L;
    }

}