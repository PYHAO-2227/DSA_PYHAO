package LeetCode.GREEDY;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) ordered.add(p[1], p);

        return ordered.toArray(new int[people.length][2]);
    }
}
