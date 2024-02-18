package META;
import LeetCode.other.TreeNode;

import java.util.*;
/* 314. Binary Tree Vertical Order Traversal
* Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.*/
public class LC314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxIdx = 0, minIdx = 0;
        while(!q.isEmpty()) {
            Node cur = q.pollFirst();
            TreeNode curNode = cur.curNode;
            int idx = cur.idx;
            if (!map.containsKey(idx)) {
                map.put(idx, new ArrayList<>());
            }
            map.get(idx).add(curNode.val);

            if (curNode.left != null) {
                q.offerLast(new Node(curNode.left, idx - 1));
            }
            if (curNode.right != null) {
                q.offerLast(new Node(curNode.right, idx + 1));
            }

            maxIdx = Math.max(idx, maxIdx);
            minIdx = Math.min(idx, minIdx);
        }

        for (int i = minIdx; i <= maxIdx; i++) {
            res.add(map.get(i));
        }

        return res;
    }

    private class Node {
        TreeNode curNode;
        int idx;
        Node(TreeNode t, int i) {
            curNode = t;
            idx = i;
        }
    }
}
