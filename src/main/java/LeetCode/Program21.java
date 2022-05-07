package leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program21 {

    @Test
    public void exec() {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(JSONObject.toJSONString(mergeTwoLists(node1, node2)));
    }


    /**
     * 自己研究的，时间复杂度超越了100%，但是空间复杂度只超越了6%，需要优化
     *
     * @author Stilesyu
     * @since 1.0
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode next = null;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                if (result == null) {
                    return list2;
                } else {
                    next.next = list2;
                }
                return result;
            } else if (list2 == null) {
                if (result == null) {
                    return list1;
                } else {
                    next.next = list1;
                }
                return result;
            } else {
                if (list1.val > list2.val) {
                    if (result == null) {
                        result = next = new ListNode(list2.val);
                    } else {
                        next = next.next = new ListNode(list2.val);
                    }
                    list2 = list2.next;
                } else {
                    if (result == null) {
                        result = next = new ListNode(list1.val);
                    } else {
                        next = next.next = new ListNode(list1.val);
                    }
                    list1 = list1.next;
                }
            }
        }
        return result;
    }


    /**
     * 递归版本
     * @author Stilesyu
     * @since 1.0
     */
    public ListNode mergeTwoListsWithRecursion(ListNode list1, ListNode list2) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
