package LeetCode.TreeMap;

import java.util.TreeMap;

public class LC731A {
    TreeMap<Integer, Integer> map;
    public LC731A() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int max = 0;
        for (int v : map.values()) {
            max += v;
            if (max > 2) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}
