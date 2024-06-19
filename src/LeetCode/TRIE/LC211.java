package LeetCode.TRIE;

public class LC211 {
    static class Trie {
        boolean isEnd;
        Trie[] children;
        Trie() {
            this.isEnd = false;
            children = new Trie[26];
        }
    }

    private void insert(String s) {
        Trie cur = this.root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    private boolean query(Trie cur, String s) {
        if (s.isEmpty()) return cur.isEnd;
        char c = s.charAt(0);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (query(cur.children[i], s.substring(1, s.length()))) return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            } else {
                return query(cur.children[idx], s.substring(1, s.length()));
            }
        }
    }

    Trie root;
    public LC211() {
        root = new Trie();
    }

    public void addWord(String word) {
        insert(word);
    }

    public boolean search(String word) {
        return query(root, word);
    }
}
