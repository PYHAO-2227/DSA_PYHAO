package Google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC2402 {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> ready = new PriorityQueue<>();
        for (int r = 0; r < n; r++) {
            ready.add(r);
        }
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] res = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!rooms.isEmpty() && rooms.peek()[0] <= start) {
                int[] freed = rooms.poll();
                ready.add(freed[1]);
            }
            if (!ready.isEmpty()) {
                int r = ready.poll();
                rooms.add(new int[]{end, r});
                res[r]++;
            } else {
                int[] earliest = rooms.poll();
                rooms.add(new int[]{earliest[0] + end - start, earliest[1]});
                res[earliest[1]]++;
            }
        }

        int maxBooked = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (res[i] > maxBooked) {
                maxBooked = res[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
