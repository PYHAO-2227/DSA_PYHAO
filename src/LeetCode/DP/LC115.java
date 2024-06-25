package LeetCode.DP;

public class LC115 {
    public int numDistinct(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < len2; i++) {
            char a = t.charAt(i);
            for (int j = 0; j < len1; j++) {
                char b = s.charAt(j);
                if (a == b) {
                    dp[j + 1][i + 1] = dp[j][i] + dp[j][i + 1];
                } else {
                    dp[j + 1][i + 1] = dp[j][i + 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
