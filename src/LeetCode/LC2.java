package LeetCode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode sentinel = new ListNode(-1), curNode = sentinel;
        while(l1 != null || l2 != null) {
            int cur = 0;
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }

            curNode.next = new ListNode((cur + add) % 10);
            curNode = curNode.next;
            add = (cur + add) / 10;
        }
        if (add == 1) {
            curNode.next = new ListNode(1);
        }
        return sentinel.next;
    }
}
