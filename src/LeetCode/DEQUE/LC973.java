package LeetCode.DEQUE;

import java.util.PriorityQueue;

public class LC973 {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length <= k) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distB - distA;
        });

        for (int[] p : points) {
            if (pq.size() < k) {
                pq.offer(p);
            } else {
                pq.offer(p);
                pq.poll();
            }
        }

        int[][] res = pq.toArray(new int[k][2]);
        return res;
    }
}
