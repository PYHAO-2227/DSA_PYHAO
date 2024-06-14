package LeetCode.BS;

import java.util.Arrays;

public class LC1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int jobTime = jobs[i][0];
            int preIdx = bs(jobs, jobTime);
            dp[i + 1] = Math.max(dp[preIdx + 1] + jobs[i][2], dp[i]);
        }
        return dp[n];
    }

    private int bs(int[][] jobs, int t) {
        int left = 0, right = jobs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
