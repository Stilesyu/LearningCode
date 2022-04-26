package leetCode;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ProgramNine {

    public static void main(String[] args) {
        System.out.println(isPalindromeWithoutConvertingString(1));
    }

    /**
     * 1221%10能够得到最后一位数字
     * 1221/10，能够得到除了最后一位的值
     * 翻转：如果直接翻转比较，可能会发生溢出。所以只翻转一半
     *
     * @author Stilesyu
     * @since 1.0
     */
    public static boolean isPalindromeWithoutConvertingString(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            return false;
        }
        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }

        //当输如为奇数时，中间那位是公用的
        //例如12321，3是公用的
        //这个时候需要/10，得到12和x比较
        return x == revertNumber || x == revertNumber / 10;
    }


    /**
     * 转换为String
     *
     * @author Stilesyu
     * @since 1.0
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xString = x + "";
        char[] chars = xString.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result = result + chars[i];
        }
        return result.equals(xString);
    }


}
