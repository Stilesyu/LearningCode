/**
 * @author Stiles yu
 * @since 1.0
 */
public class CodeVisibility {
    public  static Boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {

            }
            System.out.println("线程A状态改变");
        }).start();
        Thread.sleep(500);
        new Thread(() -> {
            flag = true;
        }).start();
    }
}
