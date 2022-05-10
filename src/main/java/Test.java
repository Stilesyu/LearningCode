import java.lang.management.ManagementFactory;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Test {

    @org.junit.Test
    public void test() {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        while (true) {

        }
    }


}
