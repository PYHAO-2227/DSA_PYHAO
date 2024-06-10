package LeetCode.DP;

public class LC673 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] maxL = new int[len];
        int[] count = new int[len];
        int res = 0, max = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            maxL[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (cur > nums[j]) {
                    if (maxL[i] == maxL[j] + 1) count[i] += count[j];
                    if (maxL[i] < maxL[j] + 1) {
                        maxL[i] = maxL[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max == maxL[i]) res += count[i];
            if (max < maxL[i]) {
                res = count[i];
                max = maxL[i];
            }
        }
        return res;
    }
}
