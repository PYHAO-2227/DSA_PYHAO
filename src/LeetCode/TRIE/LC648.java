package LeetCode.TRIE;

import java.util.List;

public class LC648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String curS = words[i];
            StringBuilder sb = new StringBuilder();
            if (root.search(curS, sb)) {
                words[i] = sb.toString();
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    }

    static class Trie {
        boolean val;
        Trie[] children;

        Trie() {
            this.val = false;
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
            cur.val = true;
        }

        boolean search(String s, StringBuilder sb) {
            Trie cur = this;
            for (char c : s.toCharArray()) {
                sb.append(c);
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    return false;
                }

                if (cur.children[idx].val) {
                    return true;
                } else {
                    cur = cur.children[idx];
                }
            }
            return false;
        }
    }
}
