package LeetCode.DP;

public class LC221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int max = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                if (cur == '0') {
                    dp[i][j] = 0;
                    continue;
                } else {
                    int size = 1;
                    int top = (i - 1) >= 0 ? dp[i - 1][j] : 0;
                    int left = (j - 1) >= 0 ? dp[i][j - 1] : 0;
                    int topLeft = 0;
                    if (i - 1 >= 0 && j - 1 >= 0) topLeft = dp[i - 1][j - 1];
                    size += Math.min(top, Math.min(left, topLeft));
                    dp[i][j] = size;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
