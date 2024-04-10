package META;

import LeetCode.other.TreeNode;

public class LC270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int next = 0;
        if ((double)root.val < target) {
            next = closestValue(root.right, target);
        } else {
            next = closestValue(root.left, target);
        }

        if (Math.abs(root.val - target) < Math.abs(next - target)) {
            return root.val;
        } else if (Math.abs(root.val - target) > Math.abs(next - target)){
            return next;
        } else {
            return Math.min(root.val, next);
        }
    }
}
