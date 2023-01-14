package cn.st4rlight.model;

/**
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-01
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
