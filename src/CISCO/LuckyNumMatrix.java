package CISCO;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] rolMax = new int[colLen];

        for (int i = 0; i < colLen; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < rowLen; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            rolMax[i] = max;
        }

        for (int[] row : matrix) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < colLen; i++) {
                if (row[i] < min) {
                    min = row[i];
                    idx = i;
                }
            }
            if (min == rolMax[idx]) {
                res.add(min);
            }
        }

        return res;
    }
}
