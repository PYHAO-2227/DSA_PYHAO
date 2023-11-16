package LeetCode;

public class LC204 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1, head);
        ListNode cur = sentinel;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return sentinel.next;
    }
}
