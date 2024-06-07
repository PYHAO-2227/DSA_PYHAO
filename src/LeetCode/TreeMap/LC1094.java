package LeetCode.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class LC1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int var : m.values()) {
            capacity -= var;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
