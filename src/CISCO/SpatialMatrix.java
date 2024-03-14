package CISCO;

import java.util.ArrayList;
import java.util.List;

public class SpatialMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bot = matrix.length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bot) break;
            for (int j = top; j <= bot; j++) {
                res.add(matrix[j][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bot][i]);
            }
            if (--bot < top) break;
            for (int j = bot; j >= top; j--) {
                res.add(matrix[j][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}
