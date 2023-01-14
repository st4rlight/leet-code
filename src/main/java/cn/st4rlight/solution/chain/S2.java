package cn.st4rlight.solution.chain;

import cn.st4rlight.model.ListNode;

/**
 * <p>注意l1、l2可能一长一短，而且remain最后可能不为0</p>
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        ListNode dummy = new ListNode();
        ListNode work = dummy;

        while (l1 != null && l2 != null) {
            int total = remain + l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            work.next = new ListNode(total % 10);
            work = work.next;
            remain = total / 10;
        }

        while (l1 != null) {
            int total = remain + l1.val;
            l1 = l1.next;
            work.next = new ListNode(total % 10);
            work = work.next;
            remain = total / 10;
        }

        while (l2 != null) {
            int total = remain + l2.val;
            l2 = l2.next;
            work.next = new ListNode(total % 10);
            work = work.next;
            remain = total / 10;
        }

        if (remain != 0) {
            work.next = new ListNode(remain);
        }

        return dummy.next;
    }
}
