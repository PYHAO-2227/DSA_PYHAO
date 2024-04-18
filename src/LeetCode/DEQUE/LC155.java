package LeetCode.DEQUE;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC155 {
    Deque<int[]> stack;
    public LC155() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.offerLast(new int[]{val, val});
        } else {
            stack.offerLast(new int[]{val, Math.min(val, stack.peekLast()[1])});
        }
    }

    public void pop() {
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast()[0];
    }

    public int getMin() {
        return stack.peekLast()[1];
    }
}
