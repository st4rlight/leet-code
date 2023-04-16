package cn.st4rlight.solution.chain.double_pointer;

import cn.st4rlight.model.ListNode;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode workA = headA;
        ListNode workB = headB;

        while (workA != null && workB != null) {
            if (workA == workB) {
                return workA;
            }
            workA = workA.next;
            workB = workB.next;
        }

        while (workA != null) {
            headA = headA.next;
            workA = workA.next;
        }
        while (workB != null) {
            headB = headB.next;
            workB = workB.next;
        }


        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }


    /**
     * 换种思想，将两条链拼接在一起，此时长度一致，遍历到的节点相等时，即是相同的节点
     * a = a + b
     * b = b + a
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode workA = headA;
        ListNode workB = headB;
        while (workA != workB) {
            workA = (workA == null) ? headB : workA.next;
            workB = (workB == null) ? headA : workB.next;
        }

        return workA;
    }
}
