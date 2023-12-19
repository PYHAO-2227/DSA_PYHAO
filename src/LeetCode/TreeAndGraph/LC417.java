package LeetCode.TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] states = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, 1, res, states);
            dfs(heights, i, n - 1, 2, res, states);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, 1, res, states);
            dfs(heights, m - 1, j, 2, res, states);
        }

        return res;
    }

    private void dfs(int[][] heights, int x, int y, int val, List<List<Integer>> res, int[][] states) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) {
            return;
        }

        if (states[x][y] == 3 || states[x][y] == val) {
            return;
        }

        states[x][y] += val;
        if (states[x][y] == 3) {
            List<Integer> temp = new LinkedList<>();
            temp.add(x);
            temp.add(y);
            res.add(new LinkedList<>(temp));
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int curH = heights[x][y];
            int nxtX = x + dir[0], nxtY = y + dir[1];
            if (nxtX < 0 || nxtX >= heights.length || nxtY < 0 || nxtY >= heights[0].length) continue;
            if (heights[nxtX][nxtY] < curH) continue;
            dfs(heights, nxtX, nxtY, val, res, states);
        }
    }
}
