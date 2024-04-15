package Google;

public class LC319 {
    int[][] memo;
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        memo = new int[rowNum][colNum];

        boolean[][] onPath = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (memo[i][j] == 0) {
                    int temp = dfs(matrix, i, j, onPath, -1);
                } else {
                    continue;
                }
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j, boolean[][] onPath, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        if (matrix[i][j] <= pre) return 0;

        if (onPath[i][j]) return 0;

        int cur = matrix[i][j];
        onPath[i][j] = true;

        if (memo[i][j] != 0) {
            onPath[i][j] = false;
            return memo[i][j];
        }

        int leftRes = dfs(matrix, i, j - 1, onPath, cur);
        int rightRes = dfs(matrix, i, j + 1, onPath, cur);
        int upRes = dfs(matrix, i - 1, j, onPath, cur);
        int downRes = dfs(matrix, i + 1, j, onPath, cur);

        int maxN = Math.max(leftRes, rightRes);
        maxN = Math.max(maxN, upRes);
        maxN = Math.max(maxN, downRes);

        memo[i][j] = maxN + 1;
        onPath[i][j] = false;
        max = Math.max(max, memo[i][j]);
        return memo[i][j];
    }
}
