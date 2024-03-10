package AMAZON;

import java.util.Arrays;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int len = intervals.length;
        boolean[] done = new boolean[len];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (done[i]) {
                continue;
            } else {
                count++;
                int[] pre = intervals[i];
                for (int j = i+1; j < len; j++) {
                    if (done[j]) continue;
                    int[] cur = intervals[j];
                    if (cur[0] >= pre[1]) {
                        done[j] = true;
                        pre = cur;
                    }
                }
            }
        }
        return count;
    }
}
