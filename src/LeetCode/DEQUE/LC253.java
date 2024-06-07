package LeetCode.DEQUE;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] inter : intervals) {
            if (q.isEmpty()) {
                q.offer(inter[1]);
                continue;
            }

            if (inter[0] >= q.peek()) {
                q.poll();
            }
            q.offer(inter[1]);
        }
        return q.size();
    }
}
