package AMAZON;
import java.util.*;

public class LC767 {
    static class Pair {
        char c;
        int count;
        Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        int len = s.length();
        if (len <= 1) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        int sum = 0, max = 0;
        for (char c : map.keySet()) {
            int num = map.get(c);
            sum += num;
            max = Math.max(max, num);
            pq.offer(new Pair(c, map.get(c)));
        }

        if (max > (sum + 1) / 2) return "";

        StringBuilder sb = new StringBuilder();
        Pair cur = null, nxt = pq.poll();
        while (!pq.isEmpty()) {
            cur = nxt;
            char now = cur.c;
            sb.append(now);
            nxt = pq.poll();
            if (cur.count - 1 > 0) {
                cur.count -= 1;
                pq.offer(cur);
            }
        }
        if (nxt.count > 1) {
            return "";
        } else {
            sb.append(nxt.c);
            return sb.toString();
        }
    }
}
