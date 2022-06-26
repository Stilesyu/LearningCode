import org.junit.Test;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ObjectResearch {
    @Test
    public void objectHeader() {
        for (int i = 0; i < 100000000; i++) {
            calculate();
        }
    }
    public void calculate() {
        Integer number = new Integer(0);
    }
}