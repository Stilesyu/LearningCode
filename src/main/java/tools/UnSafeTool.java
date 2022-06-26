package tools;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class UnSafeTool {


    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Class<Unsafe> clz = Unsafe.class;
        Field field = clz.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(new Object());
    }

}
