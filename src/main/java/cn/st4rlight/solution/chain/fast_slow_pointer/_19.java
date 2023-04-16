package cn.st4rlight.solution.chain.fast_slow_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode fast = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
