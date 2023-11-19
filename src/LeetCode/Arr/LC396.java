package LeetCode.Arr;

public class LC396 {
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int sum = 0, f = 0, n = nums.length, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        res = Math.max(res, f);
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            res = Math.max(res, f);
        }

        return res;
    }
}
