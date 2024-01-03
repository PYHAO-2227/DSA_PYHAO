package LeetCode.other;

import java.util.PriorityQueue;

public class LC23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;
        ListNode sentinel = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < len; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                pq.add(cur);
                cur = cur.next;
            }
        }

        ListNode pointer = sentinel;
        while (!pq.isEmpty()) {
            pointer.next = pq.poll();
            pointer = pointer.next;
        }
        pointer.next = null;
        return sentinel.next;
    }
}
