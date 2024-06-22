package AMAZON;

import java.util.Arrays;

public class LC950 {
    static class Node {
        int val;
        Node nxt, pre;
        Node(int val) {
            this.val = val;
        }
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Node sentinel = new Node(-1);
        sentinel.nxt = sentinel;
        sentinel.pre = sentinel;
        for (int i = deck.length - 1; i >= 0; i--) {
            int cur = deck[i];
            Node newNode = new Node(cur);
            rotate(sentinel);
            newNode.pre = sentinel;
            newNode.nxt = sentinel.nxt;
            sentinel.nxt.pre = newNode;
            sentinel.nxt = newNode;
        }
        Node curNode = sentinel.nxt;
        int[] res = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            res[i] = curNode.val;
            curNode = curNode.nxt;
        }
        return res;
    }

    private void rotate(Node sentinel) {
        if (sentinel.nxt == sentinel || sentinel.nxt.nxt == sentinel) return;
        Node last = sentinel.pre;
        last.pre.nxt = sentinel;
        sentinel.pre = last.pre;
        last.nxt = sentinel.nxt;
        last.pre = sentinel;
        sentinel.nxt.pre = last;
        sentinel.nxt = last;
    }
}
