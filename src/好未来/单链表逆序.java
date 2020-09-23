package 好未来;

/*  单链表逆序
    讲一个有链表头的单向单链表逆序。

    输入：
    {1,2,3,4,5}
    输出：
    {5,4,3,2,1}

    输入：
    {1}
    输出：
    {1}

    输入：
    {}
    输出：
    {}
 */

public class 单链表逆序 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.setData(1);
        ListNode next = new ListNode();
        next.setData(2);
        head.setNext(next);
        ListNode newHead = reverseList(head);
        System.out.println(newHead.getData());
        ListNode newNext = newHead.getNext();
        System.out.println(newNext.getData());
    }

    public static ListNode reverseList (ListNode head) {
        if (head == null || head.getNext() == null) return head;

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        return prev;
    }
}

class ListNode {
    private int data;
    private ListNode next;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
