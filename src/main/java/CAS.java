import org.junit.Test;
import sun.misc.Unsafe;
import tools.UnSafeTool;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class CAS {

    private  int num = 0;
    private  int state = 0;

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    if (casState(0,  1)) {
                        num++;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }, "当前线程:" + i).start();
        }
        System.out.println(num);
    }


    public boolean casState(int oldValue, int newValue) throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = UnSafeTool.getUnsafe();
        long offSet = unsafe.objectFieldOffset(CAS.class.getDeclaredField("state"));
        return unsafe.compareAndSwapInt(this, offSet, oldValue, newValue);
    }


}
