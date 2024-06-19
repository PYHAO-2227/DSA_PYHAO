package LeetCode.TRIE;

public class LC677 {
    static class Trie {
        boolean isEnd;
        int val, sum;
        Trie[] children;
        Trie() {
            this.val = 0;
            this.isEnd = false;
            children = new Trie[26];
        }
    }
    private final Trie root;

    private void insertT(String s, int n) {
        Trie cur = this.root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
            cur.sum += n;
        }
        cur.isEnd = true;
        cur.val += n;
    }

    private int search(String s) {
        Trie cur = this.root;
        for (int c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) return -1;
            cur = cur.children[idx];
        }
        if (cur.isEnd) {
            return cur.val;
        } else {
            return -1;
        }
    }

    private int findSum(String prefix) {
        Trie cur = this.root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.sum;
    }

    public LC677() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        int query = search(key);
        if (query == -1) {
            insertT(key, val);
        } else {
            insertT(key, val - query);
        }
    }

    public int sum(String prefix) {
        return findSum(prefix);
    }
}
