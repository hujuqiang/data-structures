package com.learning.datastructures.leetcode;

/**
 * 203.移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {

    /**
     * 无头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            if(val == head.val) {
                head = head.next;
            }
        }
        if(head == null) {
            return null;
        }
        ListNode pre = head;
        while(pre.next != null) {
            if(pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    /**
     * 有头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null) {
            if(pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution203().removeElements3(head, 6);
        System.out.println(res);
    }

}
