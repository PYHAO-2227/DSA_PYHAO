package LeetCode.TRIE;
import java.util.*;
public class LC472 {
    class Trie {
        boolean isEnd;
        Trie[] children;
        Trie() {
            isEnd = false;
            children = new Trie[26];
        }
    }

    private void add(String s) {
        Trie cur = this.root;
        for (char c : s.toCharArray()) {
            int idx = c- 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    private boolean check(String s, int start, boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start]) return false;

        memo[start] = true;

        Trie cur = this.root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
            if (cur.isEnd) {
                if (check(s, i + 1, memo)) return true;
            }
        }
        return false;
    }

    Trie root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String s : words) {
            if (s.equals("")) continue;
            boolean[] memo = new boolean[s.length()];
            if (check(s, 0, memo)) res.add(s);
            add(s);
        }
        return res;
    }
}
