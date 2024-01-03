package LeetCode.other;

public class LC152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        for (int i = 1; i < len; i++) {
            int nextMax = 0, nextMin = 0;
            nextMax = Math.max(nums[i], nums[i] * preMax);
            nextMax = Math.max(nextMax, nums[i] * preMin);
            nextMin = Math.min(nums[i], nums[i] * preMin);
            nextMin = Math.min(nextMin, nums[i] * preMax);

            preMax = nextMax;
            preMin = nextMin;

            max = Math.max(max, preMax);
        }

        return max;
    }
}
