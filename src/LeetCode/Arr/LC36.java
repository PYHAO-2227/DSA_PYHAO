package LeetCode.Arr;

import java.util.HashSet;
import java.util.Set;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] blockSet = new HashSet[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                int blockRow = i / 3;
                int blockCol = j / 3;
                int blockIdx = 3 * blockRow + blockCol;
                if (rowSet[i] == null) rowSet[i] = new HashSet<>();
                if (colSet[j] == null) colSet[j] = new HashSet<>();
                if (blockSet[blockIdx] == null) blockSet[blockIdx] = new HashSet<>();
                if (rowSet[i].contains(cur) || colSet[j].contains(cur) ||
                        blockSet[blockIdx].contains(cur)) {
                    return false;
                }
                rowSet[i].add(cur);
                colSet[j].add(cur);
                blockSet[blockIdx].add(cur);
            }
        }

        return true;
    }
}
