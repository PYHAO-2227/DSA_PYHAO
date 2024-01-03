package LeetCode.other;

public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode curO = head;
        ListNode curE = head.next;
        odd.next = curO;
        even.next = curE;
        while (curO.next != null && curE.next != null) {
            curO.next = curO.next.next;
            curO = curO.next;
            curE.next = curE.next.next;
            curE = curE.next;
        }
        curO.next = even.next;
        return odd.next;
    }
}
