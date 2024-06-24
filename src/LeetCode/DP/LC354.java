package LeetCode.DP;

import java.util.Arrays;

public class LC354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int len = envelopes.length;
        int[] tails = new int[len];
        int maxLen = 1;
        tails[0] = envelopes[0][1];
        for (int i = 1; i < len; i++) {
            int cur = envelopes[i][1];
            int left = 0, right = maxLen - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (tails[mid] < cur) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            tails[left] = cur;
            maxLen = Math.max(maxLen, left + 1);
        }
        return maxLen;
    }
}
