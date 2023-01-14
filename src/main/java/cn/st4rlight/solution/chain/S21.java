package cn.st4rlight.solution.chain;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class S21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode work = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                work.next = list1;
                list1 = list1.next;
            } else {
                work.next = list2;
                list2 = list2.next;
            }

            work = work.next;
        }

        if (list1 != null) {
            work.next = list1;
        }
        if (list2 != null) {
            work.next = list2;
        }

        return dummy.next;
    }
}
