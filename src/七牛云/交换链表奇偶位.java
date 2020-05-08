package 七牛云;

/*  LC 24
    Input: A->B->C->D->E->F->G
    Output: B->A->D->C->F->E->G
 */

public class 交换链表奇偶位 {
    public ListNode ExchangeOddEvenNode(ListNode input) {
        ListNode dummy = new ListNode(0);
        dummy.next = input;

        ListNode prevNode = dummy;

        while (input != null && input.next != null) {

            ListNode oddNode = input;
            ListNode evenNode = input.next;

            // A->C
            oddNode.next = evenNode.next;
            // B->A
            evenNode.next = oddNode;
            // prev->B->A
            prevNode.next = evenNode;

            // 准备下一个 pair 的交换
            // prev = A
            prevNode = oddNode;
            // input = C
            input = oddNode.next;
        }
        return dummy.next;
    }
}

class ListNode {
    public int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
