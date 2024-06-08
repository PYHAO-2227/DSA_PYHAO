package LeetCode.SegmentTree;

public class LC731B {
    public LC731B() {

    }

    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) >= 2) {
            return false;
        } else {
            update(root, 0, N, start, end - 1, 1);
            return true;
        }
    }


    class Node {
        Node left, right;
        int val, add;
    }

    private int N = (int)1e9;
    private Node root = new Node();
    public void update (Node node, int start, int end, int l, int r, int val) {
        if (l <= start && r >= end) {
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }

    private void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    public int query(Node node, int start, int end, int l, int r) {
        if (start >= l && end <= r) return node.val;
        pushDown(node);
        int mid = (start + end) >> 1;
        int res = 0;
        if (l <= mid) res = query(node.left, start, mid, l, r);
        if (r > mid) res = Math.max(res, query(node.right, mid + 1, end, l, r));
        return res;
    }

    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
}
