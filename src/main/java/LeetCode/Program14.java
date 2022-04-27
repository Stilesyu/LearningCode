package leetCode;

import org.junit.Test;

/**
 * 14.查找字符串数组中的最长公共前缀。
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program14 {

    @Test
    public void exec() {
        String[] strings = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefixVerticalScanning(strings));
    }

    public String longestCommonPrefixVerticalScanning(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        int firstEleLength = strs[0].length();
        String firstEle = strs[0];
        for (int i = 0; i < firstEleLength; i++) {
            for (int k = 1; k < strs.length; k++) {
                if ( i == strs[k].length() || firstEle.charAt(i) != strs[k].charAt(i)) {
                    return firstEle.substring(0, i);
                }
            }
        }
        return firstEle;
    }

    /**
     * 自己编写，横向扫描法
     *
     * @author Stilesyu
     * @since 1.0
     */
    public String longestCommonPrefixHorizontalScanning(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = Math.min(result.length(), strs[i].length());
            if (index < result.length()) {
                result = result.substring(0, index);
            }
            for (int k = 0; k < index; k++) {
                if (result.charAt(k) != strs[i].charAt(k)) {
                    result = strs[i].substring(0, k);
                    break;
                }
            }
            if ("".equals(result)) {
                return result;
            }
        }
        return result;
    }


}


