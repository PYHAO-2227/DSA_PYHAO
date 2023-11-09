package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length, res = 0;
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i =  0; i < len; i++) {
            numToIdx.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    break;
                }

                int pre = numToIdx.getOrDefault(arr[i] - arr[j], -1);
                if (pre == -1) {
                    continue;
                }

                dp[i][j] = Math.max(3, dp[j][pre] + 1);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
