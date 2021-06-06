package com.leetcode.link;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     列表中的节点在范围 [0, 10^4] 内
 *     1 <= Node.val <= 50
 *     0 <= k <= 50
 *
 */
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        /*//去除等于val的头结点
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null){
            return head;
        }
        //去除等于val的非头结点
        ListNode temp = head;
        while (temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;*/
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        while(temp.next!=null){
            if (temp.next.val==val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return newHead.next;

    }

    public static ListNode returnListNode(List<Integer> list){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,7,7,7);
        ListNode head = returnListNode(list);
        ListNode listNode = removeElements(head, 3);
        while(listNode != null){
            System.out.print(listNode.val+"\t");
            listNode=listNode.next;
        }
    }



}
