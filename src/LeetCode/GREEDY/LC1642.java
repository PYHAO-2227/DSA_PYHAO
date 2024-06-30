package LeetCode.GREEDY;

import java.util.PriorityQueue;

public class LC1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bCount = bricks;
        int len = heights.length;
        int i = 0;
        for (; i < len - 1; i++) {
            if (heights[i + 1] <= heights[i]) continue;
            int gap = heights[i + 1] - heights[i];
            if (pq.size() < ladders) {
                pq.offer(gap);
                continue;
            }
            if (!pq.isEmpty() && gap > pq.peek()) {
                int temp = gap;
                gap = pq.poll();
                pq.offer(temp);
            }
            if (gap > bCount) break;
            else {
                bCount -= gap;
            }
        }
        return i;
    }
}
