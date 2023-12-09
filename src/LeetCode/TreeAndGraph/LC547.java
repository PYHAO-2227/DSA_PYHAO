package LeetCode.TreeAndGraph;

public class LC547 {
    private void dfs(int[][] isConnected, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (i != index && !visited[i] && isConnected[i][index] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }
}
