package Google;

public class LC707 {

    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    Node sentinel;
    int size;
    public LC707() {
        this.sentinel = new Node(-1);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || (index + 1) > size) {
            return -1;
        }
        Node cur = sentinel;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node preNode = sentinel;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node newNode = new Node(val);
        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node preNode = sentinel;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        size--;
    }
}
