package leetCode;

import org.junit.Test;

/**
 * 实现Java中indexOf函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * haystack = "hello", needle = "ll"
 * return 2
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program28 {

    @Test
    public void exec() {
        System.out.println(strStr("mississippi", "mississippi"));
    }

    /**
     * 暴力解法
     *
     * @author Stilesyu
     * @since 1.0
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || "".equals(haystack) || "".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        int point;
        First:
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needle.charAt(0) && chars.length - i >= needle.length()) {
                point = i + 1;
                for (int j = 1; j < needle.length(); j++) {
                    if (chars[point++] != needle.charAt(j)) {
                        continue First;
                    }
                }
                return i;
            }
        }
        return -1;
    }




}
