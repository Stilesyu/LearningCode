package leetCode;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program20 {

    @Test
    public void exec() {
        System.out.println(isValid("([](){})"));
    }

    /**
     * 用栈,当遇到方向朝左，弹出栈
     *
     * @author Stilesyu
     * @since 1.0
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.addFirst(s.charAt(i));
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
