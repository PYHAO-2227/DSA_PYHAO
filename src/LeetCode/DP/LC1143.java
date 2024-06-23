package LeetCode.DP;

public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            char c1 = text1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
