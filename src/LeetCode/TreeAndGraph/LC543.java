package LeetCode.TreeAndGraph;

import LeetCode.TreeNode;

public class LC543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(max, left + right + 1) - 1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
