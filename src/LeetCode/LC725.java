package LeetCode;

public class LC725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];

        int size = 0;
        ListNode p = head;
        while(p != null) {
            size++;
            p = p.next;
        }

        int avg = size / k;
        if (avg == 0) {
            ListNode cur = head;
            int j = 0;
            while (cur != null) {
                res[j] = cur;
                cur = cur.next;
                res[j].next = null;
                j++;
            }
            return res;
        }

        int remain = size % k;

        ListNode end = head;
        ListNode newHead = head;
        int i = 0;
        for (; i < remain; i++) {
            end = newHead;
            int range = avg + 1;
            for (int j = 1; j < range; j++) {
                end = end.next;
            }
            res[i] = newHead;
            newHead = end.next;
            end.next = null;
        }

        for (; i < k; i++) {
            end = newHead;
            int range = avg;
            for (int j = 1; j < range; j++) {
                end = end.next;
            }
            res[i] = newHead;
            newHead = end.next;
            end.next = null;
        }
        return res;
    }
}
