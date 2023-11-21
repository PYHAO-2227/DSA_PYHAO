package LeetCode.DP;

public class LC718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] != nums2[j]) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }
}
