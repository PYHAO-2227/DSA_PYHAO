package LeetCode.DP;

public class LC474 {
    class Pair {
        int total;
        int zeros;
        int ones;
        Pair (String s) {
            total = s.length();
            zeros = 0;
            ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                if (c == '1') ones++;
            }
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Pair[] ps = new Pair[len];
        for (int i = 0; i < len; i++) {
            ps[i] = new Pair(strs[i]);
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < len; i++) {
            Pair cur = ps[i];
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    int chose = 0;
                    if (j - cur.zeros >= 0 && k - cur.ones >= 0) {
                        chose = dp[j - cur.zeros][k - cur.ones] + 1;
                    }
                    dp[j][k] = Math.max(dp[j][k], chose);
                }
            }
        }

        return dp[m][n];
    }
}
