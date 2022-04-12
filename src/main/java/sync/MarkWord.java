package sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class MarkWord {
    public static void main(String[] args) throws Throwable {
        MarkWord markWord = new MarkWord();
        markWord.add();
    }
    public synchronized void add() {
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}
