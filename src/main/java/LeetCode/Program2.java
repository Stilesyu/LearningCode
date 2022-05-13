package LeetCode;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Program2 {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(2);
        nodeA.next = new ListNode(4);
        nodeA.next.next = new ListNode(3);
        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(nodeA, nodeB);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = null, head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }
}


class ListNode {
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
}
