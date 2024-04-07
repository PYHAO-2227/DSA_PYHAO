package Google;

import java.util.*;

public class LC1136 {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n]; // udx start with 1
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : relations) {
            int pre = pair[0];
            int nxt = pair[1];
            inDegree[nxt - 1]++;
            graph.get(pair[0] - 1).add(nxt);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offerLast(i + 1);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int cur = q.pollFirst();
                n--;
                for (int nxt : graph.get(cur - 1)) {
                    inDegree[nxt - 1]--;
                    if (inDegree[nxt - 1] == 0) {
                        q.offerLast(nxt);
                    }
                }
            }
            count++;
        }

        return n == 0 ? count : -1;

    }
}
