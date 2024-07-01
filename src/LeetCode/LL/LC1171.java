package LeetCode.LL;

import LeetCode.other.ListNode;

public class LC1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode sentinel = new ListNode(-1), valid = sentinel;
        ListNode cur = head;
        while (cur != null) {
            ListNode endPoint = check(cur);
            if (endPoint == null) {
                valid.next = cur;
                valid = valid.next;
                cur = cur.next;
            } else {
                cur = endPoint.next;
            }
        }
        valid.next = null;
        return sentinel.next;
    }

    private ListNode check(ListNode start) {
        int sum = 0;
        ListNode cur = start;
        while (cur != null) {
            sum += cur.val;
            if (sum == 0) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return cur;
    }
}
