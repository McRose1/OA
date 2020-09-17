package 华为;

/*  从单向链表中删除指定值的节点
    输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。

    详细描述：
    本题为考察链表的插入和删除知识。
    链表的值不能重复
    构造过程，例如
    1 <- 2
    3 <- 2
    5 <- 1
    4 <- 5
    7 <- 2
    最后的链表的顺序为 2 7 3 1 5 4

    删除 结点 2
    则结果为 7 3 1 5 4

    输入描述:
    1 输入链表结点个数
    2 输入头结点的值
    3 按照格式插入各个结点
    4 输入要删除的结点的值

    输出描述:
    输出删除结点后的序列，每个数后都要加空格

    示例1
    输入
    5
    2
    3 2
    4 3
    5 2
    1 4
    3
    输出
    2 5 4 1
 */

import java.util.Scanner;
import java.util.Stack;

public class 从单向链表中删除指定值的节点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int headVal = sc.nextInt();
        ListNode head = new ListNode(headVal);
        for (int i = 0; i < n - 1; i++) {
            int nextVal = sc.nextInt();
            int preVal = sc.nextInt();
            insert(head, preVal, nextVal);
        }
        int deleteVal = sc.nextInt();
        head = remove(head, deleteVal);
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(head.val + " ");
    }

    private static void insert(ListNode head, int preVal, int nextVal) {
        ListNode next = new ListNode(nextVal);
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == preVal) {
                next.next = cur.next;
                cur.next = next;
                break;
            }
            cur = cur.next;
        }
    }

    private static ListNode remove(ListNode head, int val) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if (head.val != val) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
