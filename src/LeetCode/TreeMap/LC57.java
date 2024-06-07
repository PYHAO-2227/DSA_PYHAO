package LeetCode.TreeMap;

import java.util.ArrayList;
import java.util.List;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> record = new ArrayList<>();
        for (int[] slot : intervals) {
            if (slot[0] > newInterval[1]) {
                record.add(newInterval);
                newInterval = slot;
            } else if (slot[1] < newInterval[0]) {
                record.add(slot);
            } else {
                newInterval[0] = Math.min(slot[0], newInterval[0]);
                newInterval[1] = Math.max(slot[1], newInterval[1]);
            }
        }
        record.add(newInterval);
        return record.toArray(new int[record.size()][]);
    }
}
