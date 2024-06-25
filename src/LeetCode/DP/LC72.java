package LeetCode.DP;

public class LC72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        String longW, shortW;
        if (len1 >= len2) {
            longW = word1;
            shortW = word2;
        } else {
            longW = word2;
            shortW = word1;
        }

        len1 = longW.length();
        len2 = shortW.length();
        word1 = longW;
        word2 = shortW;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int j = 0; j < len2; j++) {
            char c2 = word2.charAt(j);
            for (int k = 0; k < len1; k++) {
                char c1 = word1.charAt(k);
                if (c1 != c2) {
                    dp[k + 1][j + 1] = Math.min(Math.min(dp[k][j] + 1, dp[k][j + 1] + 1), dp[k + 1][j] + 1);
                } else {
                    dp[k + 1][j + 1] = dp[k][j];
                }
            }
        }

        return dp[len1][len2];
    }
}
