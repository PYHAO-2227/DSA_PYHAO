package LeetCode.TreeAndGraph;
import java.util.*;
public class LC2812 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0,1}, {0, -1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (n <= 1) return 0;
        bfs(grid);

        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, grid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int max, List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) < max || grid.get(n-1).get(n-1) < max) return false;  // Start or end is not safe enough
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0, 0});
        visited[0][0] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for (int[] dir : dirs) {
                int nxtX = cur[0] + dir[0], nxtY = cur[1] + dir[1];
                if (nxtX >= 0 && nxtX < n && nxtY >= 0 && nxtY < n && !visited[nxtX][nxtY] && grid.get(nxtX).get(nxtY) >= max) {
                    if (nxtX == n-1 && nxtY == n-1) return true;  // Reached the end
                    queue.offerLast(new int[]{nxtX, nxtY});
                    visited[nxtX][nxtY] = true;
                }
            }
        }
        return false;
    }

    private void bfs(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distance = new int[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        // Initialize distances to a large value and start BFS from each thief
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offerLast(new int[]{i, j});
                    distance[i][j] = 0;  // Distance from a thief to itself is 0
                }
            }
        }
        // Directions for moving in the grid
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // BFS to calculate minimum distances
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int curX = cur[0], curY = cur[1];
            for (int[] dir : dirs) {
                int nxtX = curX + dir[0], nxtY = curY + dir[1];
                if (nxtX >= 0 && nxtX < n && nxtY >= 0 && nxtY < n && distance[nxtX][nxtY] == Integer.MAX_VALUE) {
                    distance[nxtX][nxtY] = distance[curX][curY] + 1;
                    queue.offerLast(new int[]{nxtX, nxtY});
                }
            }
        }
        // Update the grid with calculated distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid.get(i).set(j, distance[i][j]);
            }
        }
    }
}
