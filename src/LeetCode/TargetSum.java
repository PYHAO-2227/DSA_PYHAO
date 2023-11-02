package LeetCode;

class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // Check if (target + sum) is odd or out of range
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) return 0;

        // Convert the problem to subset sum problem
        int subsetSum = (target + sum) / 2;

        int[][] dp = new int[n + 1][subsetSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int cur = nums[i - 1];
            for (int j = 0; j <= subsetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - cur >= 0) {
                    dp[i][j] += dp[i - 1][j - cur];
                }
            }
        }
        return dp[n][subsetSum];
    }
}
