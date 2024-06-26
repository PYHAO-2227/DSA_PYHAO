package LeetCode.DP;
/*
* 想清楚转移条件 -> dp[i][j] = dp[i - 1][j] + "dp[i][j - curVal]" 而不是dp[i - 1];
* */
public class LC518 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            int cur = coins[i];
            for (int j = cur; j <= amount; j++) {
                dp[j] += dp[j - cur];
            }
        }
        return dp[amount];
    }
}
