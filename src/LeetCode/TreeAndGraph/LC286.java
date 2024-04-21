package LeetCode.TreeAndGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class LC286 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void wallsAndGates(int[][] rooms) {
        HashSet<int[]> gates = new HashSet<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    gates.add(new int[]{i, j});
                }
            }
        }
        if (gates.isEmpty()) return;
        for (int[] gate : gates) {
            bfs(rooms, gate);
        }
        return;
    }

    private void bfs(int[][] rooms, int[] gate) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        queue.offerLast(gate);
        visited[gate[0]][gate[1]] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                rooms[cur[0]][cur[1]] = Math.min(rooms[cur[0]][cur[1]], distance);
                for (int[] dir : dirs) {
                    int nxtRow = cur[0] + dir[0];
                    int nxtCol = cur[1] + dir[1];
                    if (nxtRow >= 0 && nxtRow < rooms.length && nxtCol >= 0 && nxtCol < rooms[0].length) {
                        if (rooms[nxtRow][nxtCol] != -1 && rooms[nxtRow][nxtCol] != 0 && !visited[nxtRow][nxtCol]) {
                            queue.offerLast(new int[]{nxtRow, nxtCol});
                            visited[nxtRow][nxtCol] = true;
                        }
                    }
                }
            }
            distance++;
        }
    }
}
