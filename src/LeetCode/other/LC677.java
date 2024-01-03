package LeetCode.other;

import java.util.HashMap;

public class LC677 {
    private HashMap<String, Node> map;
    private static class Node {
        int val = 0;
        Node[] children;

        public Node(int val) {
            this.val = val;
            children = new Node[26];
        }
    }
    private final Node root;

    public LC677() {
        map = new HashMap<>();
        root = new Node(0);
    }

    public void insert(String key, int val) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            target.val = val;
        } else {
            Node newNode = insertTrie(key, val);
            map.put(key, newNode);
        }
    }

    public int sum(String prefix) {
        char[] cArr = prefix.toCharArray();
        Node cur = root;
        for (char c : cArr) {
            int i = c - 'a';
            if (cur.children[i] == null) return 0;
            cur = cur.children[i];
        }
        return sumTrie(cur);
    }

    private int sumTrie(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        for (Node n : root.children) {
            if (n != null) sum += sumTrie(n);
        }
        return sum;
    }

    private Node insertTrie(String key, int val) {
        char[] cArr = key.toCharArray();
        Node cur = root;
        for (char c : cArr) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node(0);
            }
            cur = cur.children[i];
        }
        cur.val = val;
        return cur;
    }
}
