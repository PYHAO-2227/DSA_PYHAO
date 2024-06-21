package AMAZON;

import java.util.Arrays;

public class LC2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int sLen = s.length();
        int qLen = queries.length;

        //left * == x; | == y
        int[] countY = new int[sLen];
        int[] leftY = new int[sLen];
        int[] rightY = new int[sLen];
        Arrays.fill(leftY, -1);
        Arrays.fill(rightY, -1);

        int preY = -1, curY = -1;
        char[] cArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = cArr[i];
            if (c == '|') {
                preY = curY;
                curY = i;
                leftY[i] = i;
                rightY[i] = i;
                for (int j = i - 1; j >= 0 && j > preY; j--) {
                    rightY[j] = curY;
                }
                countY[i] = i == 0 ? 1 : countY[i - 1] + 1;
            } else {
                leftY[i] = curY;
                countY[i] = i == 0 ? 0 : countY[i - 1];
            }
        }

        int[] res = new int[qLen];
        for (int k = 0; k < qLen; k++) {
            int qL = queries[k][0], qR = queries[k][1];
            int leftBound = rightY[qL];
            if (leftBound < 0 || leftBound  > qR) {
                res[k] = 0;
                continue;
            }
            int rightBound = leftY[qR];
            if (rightBound < 0 || rightBound <= leftBound || rightBound < qL) {
                res[k] = 0;
                continue;
            }
            int total = rightBound - leftBound + 1;
            int numY = countY[rightBound] - countY[leftBound] + 1;
            res[k] = total - numY;
        }
        return res;
    }
}
