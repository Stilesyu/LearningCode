package sync;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Test {

    public Object o = new Object();

    public void methodA() {
        synchronized (o) {
            //.....
        }
    }

    public void methodB() {
        Object o1 = new Object();
        synchronized (o1) {
            //.....
        }
    }


    public synchronized void methodB() {

    }

    public static synchronized void methodC() {

    }

}
