package LeetCode.TRIE;

import java.util.Arrays;

public class LC676 {
    static class Trie {
        boolean isEnd;
        Trie[] children;
        Trie() {
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }
    private final Trie root;

    private void add (String s) {
        Trie cur = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new Trie();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    private boolean dfs(Trie node, String s, int start, int change) {
        if (change > 1) return false;

        if (start == s.length()) {
            return node.isEnd && change == 1;
        }

        char cur = s.charAt(start);
        int idx = cur - 'a';
        if (node.children[idx] != null) {
            if (dfs(node.children[idx], s, start + 1, change)) return true;
        }

        if (change < 1) {
            for (Trie nxt : node.children) {
                if (nxt == null || nxt == node.children[idx]) continue;
                if (dfs(nxt, s, start + 1, change + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public LC676() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            add(s);
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }
}
