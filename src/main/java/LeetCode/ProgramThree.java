package leetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ProgramThree {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    //pwwkew
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}