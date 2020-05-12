package 映客;

/*
    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的。

    输入：
    [2,4,3],[1,1,1]

    输出：
    {3,5,4}
 */

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        dummy.next = l1;
        while (l1 != null) {
            l1.val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;
}
