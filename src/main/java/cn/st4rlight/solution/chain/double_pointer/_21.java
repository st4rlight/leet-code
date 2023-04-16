package cn.st4rlight.solution.chain.double_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                last.next = list1;
                list1 = list1.next;
            } else {
                last.next = list2;
                list2 = list2.next;
            }

            last = last.next;
            last.next = null;
        }

        if (list1 != null) {
            last.next = list1;
        }
        if (list2 != null) {
            last.next = list2;
        }

        return dummy.next;
    }
}
