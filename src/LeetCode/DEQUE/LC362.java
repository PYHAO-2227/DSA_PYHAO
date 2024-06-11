package LeetCode.DEQUE;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC362 {
    Deque<Integer> q;
    public LC362() {
        q = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        while (!q.isEmpty() && q.peekFirst() <= timestamp - 300) {
            q.pollFirst();
        }
        q.offerLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peekFirst() <= timestamp - 300) {
            q.pollFirst();
        }
        return q.size();
    }
}
