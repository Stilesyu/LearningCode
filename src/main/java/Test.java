import java.util.Stack;
import java.util.Vector;


/**
 * @author Stiles yu
 * @since 1.0
 */
public class Test {

    @org.junit.Test
    public void test() {
        Vector vector = new Stack();
        Vector v  = (Vector) vector.clone();
        System.out.println(v.getClass());

    }


}
