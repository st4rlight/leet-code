package cn.st4rlight.solution.chain.double_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _86 {

    public ListNode partition(ListNode head, int x) {
        ListNode minDummy = new ListNode();
        ListNode maxDummy = new ListNode();
        ListNode minLast = minDummy;
        ListNode maxLast = maxDummy;

        while (head != null) {
            if (head.val < x) {
                minLast.next = head;
                minLast = head;
            } else {
                maxLast.next = head;
                maxLast = head;
            }

            head = head.next;
            minLast.next = null;
            maxLast.next = null;
        }

        minLast.next = maxDummy.next;
        return minDummy.next;
    }
}
