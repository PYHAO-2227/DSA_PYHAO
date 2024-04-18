package LeetCode.DEQUE;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        findAll(sb, 0, 0, n);
        return res;
    }

    private void findAll(StringBuilder sb, int leftCount, int rightCount, int total) {
        if (sb.length() == total * 2) {
            res.add(sb.toString());
        }

        if (leftCount < total) {
            sb.append("(");
            findAll(sb, leftCount + 1, rightCount, total);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (leftCount > rightCount) {
            sb.append(")");
            findAll(sb, leftCount, rightCount + 1, total);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
