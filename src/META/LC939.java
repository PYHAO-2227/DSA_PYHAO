package META;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        int min = Integer.MAX_VALUE;
        int num = points.length;
        for (int i = 0; i < num; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < num; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    int l = Math.abs(p1[0] - p2[0]);
                    int h = Math.abs(p1[1] - p2[1]);
                    min = Math.min(min, l * h);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
