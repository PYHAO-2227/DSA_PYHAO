package LeetCode.DP;

public class LC583 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int maxOverlap = 0;
        if (len1 >= len2) {
            maxOverlap = lcs(word1, word2);
        } else {
            maxOverlap = lcs(word2, word1);
        }
        return (len1 + len2 - 2*maxOverlap);
    }

    private int lcs(String l, String s) {
        int len1 = l.length(), len2 = s.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int j = 0; j < len2; j++) {
            char sc = s.charAt(j);
            for(int i = 0; i < len1; i++) {
                char lc = l.charAt(i);
                if (sc == lc) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
