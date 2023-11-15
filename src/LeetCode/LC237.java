package LeetCode;

public class LC237 {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
