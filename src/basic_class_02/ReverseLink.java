package basic_class_02;

import java.util.Stack;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 *
 * 提示：
 *
 *     链表中节点数目为 n
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 *
 *
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class ReverseLink {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode firstNode = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (head !=null){
            if(index == left-1){
                leftNode = head;
            }
            if(index == right+1){
                rightNode = head;
            }
            if(index >= left && index <= right){
                stack.push(head.val);
            }
            index++;
            head=head.next;
        }
        if(!stack.empty() && leftNode!= null && rightNode != null){
            while (!stack.empty()){
                ListNode newNode = new ListNode(stack.pop());
                leftNode.next = newNode;
                leftNode = leftNode.next;
            }
            leftNode.next=rightNode;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode first = head;
        for (int i = 1; i < 6; i++) {
            ListNode newNode = new ListNode(i);
            head.next = newNode;
            head = head.next;
        }
        ListNode listNode = reverseBetween(first, 2, 4);
        System.out.println();
    }
}
