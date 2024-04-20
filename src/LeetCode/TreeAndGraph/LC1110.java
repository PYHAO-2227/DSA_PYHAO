package LeetCode.TreeAndGraph;

import LeetCode.other.TreeNode;
import java.util.*;

public class LC1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] toDel) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<TreeNode> set = new HashSet<>();
        Set<Integer> delSet = new HashSet<>();
        for (int n : toDel) {
            delSet.add(n);
        }
        set.add(root);
        dfs(root, set, delSet);
        res.addAll(set);
        return res;
    }

    private TreeNode dfs(TreeNode root, Set<TreeNode> set, Set<Integer> delSet) {
        if (root == null) return null;
        int curVal = root.val;
        root.left = dfs(root.left, set, delSet);
        root.right = dfs(root.right, set, delSet);
        if (delSet.contains(curVal)) {
            set.remove(root);
            if (root.left != null) set.add(root.left);
            if (root.right != null) set.add(root.right);
        }
        return delSet.contains(curVal) ? null : root;
    }
}
