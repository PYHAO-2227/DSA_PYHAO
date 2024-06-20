package AMAZON;

import java.util.PriorityQueue;

public class LC2268 {
    public int minimumKeypresses(String s) {
        if (s.length() <= 9) return s.length();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]++;
        }

        int[] pos = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < 26; i++) {
            pq.offer(new int[]{i, count[i]});
        }

        int keyCount = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res += cur[1] * ((keyCount + 9) / 9);
            keyCount++;
        }
        return res;
    }
}
