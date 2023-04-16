package cn.st4rlight.solution.chain.double_pointer;

import java.util.PriorityQueue;

import cn.st4rlight.model.ListNode;

/**
 * 合并k个有序链表
 * 1. 归并实现
 * 2. 采用最小堆实现
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeRangeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeRangeList(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        ListNode leftPart = mergeRangeList(lists, left, mid);
        ListNode rightPart = mergeRangeList(lists, mid + 1, right);

        return mergeTwoList(leftPart, rightPart);
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                last.next = a;
                a = a.next;
            } else {
                last.next = b;
                b = b.next;
            }

            last = last.next;
            last.next = null;
        }

        if (a != null) {
            last.next = a;
        }
        if (b != null) {
            last.next = b;
        }

        return dummy.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode last = dummy;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.add(list.val);
                list = list.next;
            }
        }

        while (!priorityQueue.isEmpty()) {
            last.next = new ListNode(priorityQueue.poll());
            last = last.next;
        }

        return dummy.next;
    }
}
