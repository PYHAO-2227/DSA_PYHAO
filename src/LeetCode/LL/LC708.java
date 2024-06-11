package LeetCode.LL;

import META.Node;

public class LC708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }

        Node max = head, min = head.next;
        while (max.val <= min.val) {
            max = max.next;
            min = min.next;
            if (max == head) break;
        }

        Node newNode = new Node(insertVal);
        if (insertVal >= max.val || insertVal <= min.val) {
            max.next = newNode;
            newNode.next = min;
            return head;
        } else {
            while (min.next.val < insertVal) {
                min = min.next;
            }
            newNode.next = min.next;
            min.next = newNode;
            return head;
        }
    }
}
