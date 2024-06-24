package LeetCode.DP;

public class LC1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = 0; i < len1; i++) {
            int up = nums1[i];
            for (int j = 0; j < len2; j++) {
                int down = nums2[j];
                if (up == down) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j+1]);
                }
            }
        }
        return max;
    }
}
