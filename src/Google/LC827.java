package Google;

import java.util.HashSet;
import java.util.Set;

public class LC827 {
    static int N = 510;
    static int[] p = new int[N * N], sz = new int[N * N];
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    int maxBlock = 0;
    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (sz[rootA] > sz[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        sz[rootB] += sz[rootA];
        p[rootA] = rootB;
        maxBlock = Math.max(maxBlock, sz[rootB]);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i <= n * n; i++) {
            p[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                    union(i * n + j + 1, x * n + y + 1);
                }
            }
        }

        int max = Math.max(maxBlock, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int curSize = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int nxt = find(x * n + y + 1);
                        if (set.contains(nxt)) continue;
                        set.add(nxt);
                        curSize += sz[nxt];
                    }
                    max = Math.max(curSize, max);
                }
            }
        }
        return max;
    }
}
