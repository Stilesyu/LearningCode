package visible;


/**
 * @author Stiles yu
 * @since 1.0
 */
public class VisibleTest {


    private   static boolean isTure = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("B");
            while (isTure) {
            }
        }).start();



        new Thread(() -> {
            System.out.println("A");
            isTure = false;
        }).start();
    }


    public synchronized void methodA(){

    }


    public void methodB(){
        synchronized ()
    }




}
