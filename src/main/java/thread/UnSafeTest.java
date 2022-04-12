package thread;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class UnSafeTest {


    @Test
    public void test() {
        Unsafe unsafe = getUnsafe();
        long a = unsafe.allocateMemory(1);
        unsafe.putInt(a, 2);
        unsafe.freeMemory(a);
        System.out.println(unsafe.getInt(a));
    }


    public Unsafe getUnsafe() {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

}
