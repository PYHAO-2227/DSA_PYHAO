package LeetCode.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class LC729 {
    TreeMap<Integer, Integer> map;
    public LC729() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> left = map.floorEntry(start);
        Map.Entry<Integer, Integer> right = map.ceilingEntry(start);

        if (left != null && left.getValue() > start) return false;
        if (right != null && right.getKey() < end) return false;
        map.put(start, end);
        return true;

    }
}
