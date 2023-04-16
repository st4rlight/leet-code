package cn.st4rlight.solution.chain.fast_slow_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
