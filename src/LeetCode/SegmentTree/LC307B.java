package LeetCode.SegmentTree;

public class LC307B {
    public LC307B(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            update(root, 0, N, i, i, nums[i]);
        }
    }

    public void update(int index, int val) {
        update(root, 0, N, index, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, 0 , N, left, right);
    }

    class Node {
        Node left, right;
        int val, add;
    }
    private int N = 30000;
    private Node root = new Node();

    private void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val = (end - start + 1) * val;
            node.add = val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }

    private void pushDown(Node node, int leftCount, int rightCount) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.val = leftCount * node.add;
        node.right.val = rightCount * node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private int query(Node node, int start, int end, int l, int r) {
        if (start >= l && end <= r) return node.val;
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        int res = 0;
        if (l <= mid) res = query(node.left, start, mid, l,r);
        if (r > mid) res += query(node.right, mid + 1, end, l, r);
        return res;
    }
}
