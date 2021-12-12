package thread;

public class ThreadSync {

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        System.out.println(start);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (Count.lock) {
                    Count.number++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (Count.lock) {
                    Count.number--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Count.number);
    }


    static class Count {
        public static final Object lock = new Object();
        public static int number = 0;
    }


}
