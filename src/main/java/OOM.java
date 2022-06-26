import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class OOM {

    private Long id;
    List<OOM> list = new ArrayList<>();

    //-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\yuxia\Desktop\jmap测试 -Xmx5M -Xms5m -XX:+PrintGCDetails
    @Test
    public void exec() {
        while (true) {
            list.add(new OOM());
        }
    }



    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(5000);
                    synchronized (lock2) {
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(5000);
                    synchronized (lock1) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("此类即将被回收");
        super.finalize();
    }
}
