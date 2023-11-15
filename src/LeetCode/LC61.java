package LeetCode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode end = head;
        int len = 1;
        while (end.next != null) {
            end = end.next;
            len++;
        }

        int dis = k % len;
        if (dis == 0) return head;

        ListNode newHead = head;
        for (int i = 1; i < len - dis; i++) {
            newHead = newHead.next;
        }

        ListNode pre = newHead;
        newHead = newHead.next;
        pre.next = null;
        end.next = head;
        return newHead;
    }
}
