package thread;

public class ThreadStudy {

    public static void main(String[] args) throws InterruptedException {
        HelloThread thread = new HelloThread();
        thread.start();
        Thread.sleep(1);
        thread.running = false;
        System.out.println("main线程");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            Thread thread = new HelloThread();
            thread.start();
            try {
                thread.join();
                System.out.println("112");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class HelloThread extends Thread {
        public volatile boolean running = true;

        @Override
        public void run() {
            int n = 0;
            while (running) {
                n++;
                System.out.println(n);
            }
        }
    }


}
