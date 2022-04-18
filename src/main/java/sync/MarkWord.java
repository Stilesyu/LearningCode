package sync;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class MarkWord {

    private volatile int a;


    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        MarkWord markWord = new MarkWord();
        markWord.add();
        markWord.hashCode();
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
//        new Thread(() -> {
//            try {
//                markWord.add();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        Thread.sleep(2000);
//        for (int i=0;i<100;i++){
//            markWord.add();
//        }
    }

    public static synchronized void abb() {
        int a = 0;
    }

    public void subtract() {
        synchronized (this) {
            System.out.println("");
        }
    }

    public synchronized void add() throws InterruptedException {
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}
