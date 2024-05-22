package META;
import java.util.*;
public class LC2316 {
    class UF {
        int[] parents;
        UF(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private void union(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti == rootj) return;
            parents[rooti] = rootj;
        }

        private int find(int i) {
            if (i == parents[i]) return i;
            int p = find(parents[i]);
            parents[i] = p;
            return p;
        }
    }
    public long countPairs(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        long result = 0;
        for (int size : componentSize.values()) {
            result += (long) size * (n - size);
        }
        return result / 2;
    }
}
