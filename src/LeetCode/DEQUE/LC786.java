package LeetCode.DEQUE;

import java.util.PriorityQueue;

public class LC786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<int[]>((a, b) -> {
            int a1 = arr[a[0]], a2 = arr[a[1]];
            int b1 = arr[b[0]], b2 = arr[b[1]];
            return Integer.compare(a1 * b2, b1 * a2);
        });
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            pq.offer(new int[]{0, i});
        }


        int[] curMin = pq.poll();
        for (int i = 1; i < k; i++) {
            pq.offer(new int[]{curMin[0] + 1, curMin[1]});
            curMin = pq.poll();
        }
        return new int[]{arr[curMin[0]], arr[curMin[1]]};
    }
}
