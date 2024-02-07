package LeetCode.STR;

import java.util.PriorityQueue;

public class LC451 {
    private class Pair {
        char key;
        int val;
        Pair (char key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public String frequencySort(String s) {
        int[] map = new int[128];
        char[] sArr = s.toCharArray();

        for (char c : sArr) {
            map[c]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.val - a.val));

        for (int i = 0; i < 128; i++) {
            if (map[i] == 0) continue;
            Pair cur = new Pair((char)i, map[i]);
            pq.offer(cur);
        }


        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (int i = 0; i < cur.val; i++) {
                sb.append(cur.key);
            }
        }

        return sb.toString();
    }
}
