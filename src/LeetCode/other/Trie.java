package LeetCode.other;

class Trie {
    private static class TrieNode {
        boolean val;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curNode.children[i] == null) {
                curNode.children[i] = new TrieNode();
                curNode = curNode.children[i];
            } else {
                curNode = curNode.children[i];
            }
        }
        curNode.val = true;
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curNode.children[i] == null) {
                return false;
            } else {
                curNode = curNode.children[i];
            }
        }
        return curNode.val;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) return false;
            p = p.children[i];
        }
        return true;
    }
}
