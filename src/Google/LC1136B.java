package Google;
import java.util.*;

public class LC1136B {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : relations) {
            graph.get(pair[0]).add(pair[1]);
        }

        boolean[] seen = new boolean[n + 1];
        int[] done = new int[n + 1];
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = dfs(graph, seen, done, i);
            if (depth == -1) {
                // Cyclic
                return -1;
            }
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }

    private int dfs(List<List<Integer>> graph, boolean[] seen, int[] done, int cur) {
        if (done[cur] > 0) {
            return done[cur];
        }

        if (seen[cur]) {
            return -1;
        }
        seen[cur] = true;
        int count = 1;
        for (int nxt : graph.get(cur)) {
            int depth = dfs(graph, seen, done, nxt);
            if (depth == -1) {
                return -1;
            }
            count = Math.max(depth + 1, count);
        }

        done[cur] = count;
        return done[cur];
    }
}
