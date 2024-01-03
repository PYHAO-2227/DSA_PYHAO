package LeetCode.LL;

import LeetCode.other.ListNode;

public class LC1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int gap = b - a + 2;
        ListNode sentinel = new ListNode(-1, list1);

        ListNode l2end =list2;
        while (l2end.next != null) {
            l2end = l2end.next;
        }

        ListNode slow = list1, fast = slow;
        for (int i = 0; i < gap; i++) {
            fast = fast.next;
        }

        for (int j = 0; j < a - 1; j++) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = list2;
        l2end.next = fast;
        return sentinel.next;
    }
}
