package META;

public class LC426 {
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node sentinel = new Node(-1);
        pre = sentinel;
        dfs(root);
        sentinel.right.left = pre;
        pre.right = sentinel.right;
        return sentinel.right;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
