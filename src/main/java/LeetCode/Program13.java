package leetCode;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Program13 {


    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println(romanToIntByDoneSpeak(roman));
    }


    /**
     * DoneSpeak编写
     *
     * @author Stilesyu
     * @since 1.0
     */
    public static int romanToIntByDoneSpeak(String s) {
        int result = 0;
        int temp = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            if (temp < current) {
                result -= temp;
            } else {
                result += temp;
            }
            temp = current;
        }
        result += temp;
        return result;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    /**
     * 自己编写，执行用时2ms，内存消耗41.2MB
     *
     * @author Stilesyu
     * @since 1.0
     */
    public static int romanToInt(String s) {
        int result = 0;
        char temp = 'o';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result = 'I' == temp ? result + 3 : result + 5;
                    break;
                case 'X':
                    result = 'I' == temp ? result + 8 : result + 10;
                    break;
                case 'L':
                    result = 'X' == temp ? result + 30 : result + 50;
                    break;
                case 'C':
                    result = 'X' == temp ? result + 80 : result + 100;
                    break;
                case 'D':
                    result = 'C' == temp ? result + 300 : result + 500;
                    break;
                case 'M':
                    result = 'C' == temp ? result + 800 : result + 1000;
                    break;
            }
            temp = c;
        }
        return result;
    }


}
