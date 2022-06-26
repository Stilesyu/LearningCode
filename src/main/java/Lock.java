import java.util.concurrent.locks.LockSupport;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Lock {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("start");
            LockSupport.park();
            LockSupport.park();
            System.out.println("end");
        });
        t1.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        t1.interrupt();
    }


}
