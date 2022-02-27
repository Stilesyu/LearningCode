import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class It {
        public static void main(String[] args) {
            testIterator t = new testIterator();
            Set<Integer> set = t.keySet();
            System.out.println(set);
        }
    }

    class testIterator {
        public Set<Integer> keySet() {

            final ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            result.add(2);
            result.add(3);

            Set<Integer> keySet = new AbstractSet<Integer>() {
                public Iterator<Integer> iterator() {
                    return new Iterator<Integer>() {
                        private Iterator<Integer> i = result.iterator();

                        @Override
                        public boolean hasNext() {
                            return i.hasNext();
                        }

                        @Override
                        public Integer next() {
                            return i.next();
                        }

                        @Override
                        public void remove() {
                            i.remove();
                        }
                    };
                }

                @Override
                public int size() {
                    return 0;
                }
            };

            return keySet;
        }
    }

