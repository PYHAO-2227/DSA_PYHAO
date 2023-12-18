package LeetCode.DP;

public class LC516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] norm = s.toCharArray();
        char[] back = new StringBuilder(s).reverse().toString().toCharArray();
        return LCS(norm, back);
    }

    private int LCS(char[] norm, char[] back) {
        int len = norm.length;
        int[][] memo = new int[len + 1][len + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                if (norm[i - 1] == back[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[len][len];
    }
}
