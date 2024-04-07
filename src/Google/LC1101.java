package Google;

import java.util.Arrays;

public class LC1101 {
    public class Union {
        int[] parent;
        int count;

        Union(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            count = size;
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                parent[pj] = pi;
                count--;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        Union u = new Union(n);
        for (int[] log : logs) {
            u.union(log[1], log[2]);
            if (u.count == 1) {
                return log[0];
            }
        }
        return -1;
    }
}
