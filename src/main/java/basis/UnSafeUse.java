package basis;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class UnSafeUse {


    public static void main(String[] args) {
        Unsafe unsafe = getUnsafe();
        long s = unsafe.allocateMemory(10);
        System.out.println(s);
        unsafe.putInt(s, 1);
        System.out.println(unsafe.getInt(s));
    }


    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Test
    public void test() throws Exception {
        CASCounter casCounter = new CASCounter();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        new Thread(casCounter::increment).start();
        System.out.println(casCounter.counter);
    }


    class CASCounter {
        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        public CASCounter() throws Exception {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long before = counter;
            while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
                before = counter;
            }
        }

        public long getCounter() {
            return counter;
        }

    }
}
