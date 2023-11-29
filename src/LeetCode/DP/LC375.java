package LeetCode.DP;

public class LC375 {
    int[][] memo;
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }

        memo = new int[n + 1][n + 1];

        return dp(1,n);
    }

    private int dp(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int cur = i + Math.max(dp(start, i - 1), dp(i + 1, end));
            res = Math.min(res, cur);
        }
        memo[start][end] = res;
        return res;
    }
}
