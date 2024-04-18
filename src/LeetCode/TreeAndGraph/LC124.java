package LeetCode.TreeAndGraph;

import LeetCode.other.TreeNode;

public class LC124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int temp = helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftRes = helper(root.left);
        int rightRes = helper(root.right);
        int curMax = Math.max(root.val, root.val + leftRes);
        curMax = Math.max(curMax, root.val + rightRes);
        max = Math.max(max, curMax);
        max = Math.max(max, root.val + leftRes + rightRes);
        return curMax;
    }
}
