package LeetCode.DP;

public class LC1049 {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        int len = stones.length;
        int sum = 0;
        for (int w : stones) {
            sum += w;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
