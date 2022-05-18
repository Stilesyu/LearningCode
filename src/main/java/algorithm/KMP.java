package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class KMP {
    @Test
    public void exec() {
        Arrays.stream(getNext("ABABAABAA".toCharArray())).forEach(System.out::println);
    }

    private int[] getNext(char[] pattern) {
        int[] result = new int[pattern.length];
        result[0] = 0;
        int len = 0, i = 1;
        while (i < pattern.length) {
            if (pattern[len] == pattern[i]) {
                result[i] = ++len;
                i++;
            } else {
                if (len > 0) {
                    len = result[len - 1];
                } else {
                    result[i] = len;
                    i++;
                }
            }
        }
        return result;
    }


}
