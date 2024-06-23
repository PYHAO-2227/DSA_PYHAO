package LeetCode.DP;

public class LC174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // base case
                if (i == m - 1 && j == n -1) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (i + 1 < m) min = Math.min(min, dp[i + 1][j]);
                if (j + 1 < n) min = Math.min(min, dp[i][j + 1]);
                int res = min - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;
            }
        }
        return dp[0][0];
    }
}
