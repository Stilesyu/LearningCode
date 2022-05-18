import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ObjectResearch {
    @Test
    public void objectHeader() {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(ClassLayout.parseInstance(new Car()).toPrintable());
    }
    class Car {
        int a;
        long b;
        Long b1;
        Object o;
    }
}
