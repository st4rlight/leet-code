package cn.st4rlight.solution.chain.double_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode last = dummy;
        while (head != null) {
            if (last.val < head.val) {
                last.next = head;
                last = head;
            }

            head = head.next;
            last.next = null;
        }

        return dummy.next;
    }
}
