package LeetCode.TRIE;

public class LC720 {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        for (String s : words) {
            root.insert(s);
        }
        String res = "";
        for (String s : words) {
            if (s.length() < res.length()) continue;
            if (s.length() == res.length() && s.compareTo(res) > 0) continue;
            if (root.search(s)) {
                res = s;
            }
        }
        return res;
    }

    static class Trie {
        boolean isEnd;
        Trie[] children;

        Trie () {
            this.isEnd = false;
            this.children = new Trie[26];
        }

        void insert(String s) {
            Trie cur = this;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }

        boolean search(String s) {
            Trie cur = this;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null || !cur.children[idx].isEnd) {
                    return false;
                }
                cur = cur.children[idx];
            }
            return cur.isEnd;
        }
    }
}
