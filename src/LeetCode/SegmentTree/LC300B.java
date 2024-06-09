package LeetCode.SegmentTree;

public class LC300B {
    private int N = (int)1e5;
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int count = query(root, -N, N, -N, n - 1) + 1;
            update(root, -N, N, n, n, count);
            res = Math.max(res, count);
        }
        return res;
    }

    class Node {
        Node left, right;
        int val, add;
    }
    private Node root = new Node();
    private void update(Node node, int start, int end, int l, int r, int val) {
        if (start > end || l > r) return;
        if (l <= start && r >= end) {
            node.val = val;
            node.add = val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid+1, end, l, r, val);
        pushUp(node);
    }

    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.val = node.val;
        node.right.val = node.val;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    private void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    private int query(Node node, int start, int end, int l, int r) {
        if (l <= start && r >= end) return node.val;
        pushDown(node);
        int res = 0, mid = (start + end) >> 1;
        if(l <= mid) res = query(node.left, start, mid, l, r);
        if (r > mid) res = Math.max(res, query(node.right, mid+1, end, l, r));
        return res;
    }
}
