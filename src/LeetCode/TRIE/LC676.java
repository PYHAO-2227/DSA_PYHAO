package LeetCode.TRIE;

import java.util.Arrays;

public class LC676 {

    private final class TrieNode {
        public int val;
        public TrieNode[] children;
        public boolean isWord;
        public boolean isRoot;

        public TrieNode(boolean isRoot) {
            this.isRoot = isRoot;
            this.val = 0;
            children = new TrieNode[26];
            Arrays.fill(children, null);
            this.isWord = false;
        }

        public TrieNode(int val) {
            this.val = val;
            children = new TrieNode[26];
            Arrays.fill(children, null);
            this.isWord = false;
            this.isRoot = false;
        }

        public void addWord(TrieNode root, String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode(index);
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }
    }

    TrieNode root;

    public LC676() {
        root = new TrieNode(true);
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            root.addWord(this.root, word);
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, this.root, 0, 0);
    }

    public boolean dfs(String searchWord, TrieNode node, int index, int charsChanged) {
        if (index == searchWord.length()) {
            return node.isWord && charsChanged == 1; // Ensure we've made at most one change
        }

        TrieNode currIndexNode = node.children[searchWord.charAt(index) - 'a'];

        // Continue with no change if the character matches
        if (currIndexNode != null) {
            if (dfs(searchWord, currIndexNode, index + 1, charsChanged)) {
                return true;
            }
        }

        // Allow one character change if not already changed
        if (charsChanged < 1) {
            for (TrieNode n : node.children) {
                if (n != null && n != currIndexNode) { // Avoid re-checking the current node
                    if (dfs(searchWord, n, index + 1, charsChanged + 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
