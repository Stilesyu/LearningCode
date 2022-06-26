package ObjectResearch;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ObjectHeader {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new int[3]).toPrintable() );
    }


}
