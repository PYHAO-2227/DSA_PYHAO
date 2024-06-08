package LeetCode.CLASSIC;

import java.util.LinkedList;

public class LC933 {
    LinkedList<Integer> list;
    public LC933() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        while (!list.isEmpty() && list.getFirst() < t - 3000) {
            list.removeFirst();
        }
        list.addLast(t);
        return list.size();
    }
}
