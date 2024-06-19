package LeetCode.SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class LC699 {
    static class Node {
        Node left, right;
        int val;
        int add;
    }
    static int N = (int)1e9;
    Node root;

    private void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && right >= end) {
            node.val = val;
            node.add = val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (left <= mid) update(node.left, start, mid, left, right, val);
        if (right > mid) update(node.right, mid + 1, end, left, right, val);
        pushUp(node);
    }

    private void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    private int query(Node node, int start, int end, int left, int right) {
        if (left <= start && right >= end) {
            return node.val;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        int res = 0;
        if (left <= mid) res = query(node.left, start, mid, left, right);
        if (right > mid) res = Math.max(res, query(node.right, mid + 1, end, left, right));
        return res;
    }

    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.val = node.add;
        node.right.val = node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        root = new Node();
        List<Integer> ans = new ArrayList<>();
        for (int[] p : positions) {
            int start = p[0];
            int len = p[1];
            int maxTop = query(root, 0, N, start, start + len - 1);
            update(root, 0, N, start, start + len - 1, len + maxTop);
            ans.add(root.val);
        }
        return ans;
    }
}
