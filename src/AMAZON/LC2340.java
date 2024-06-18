package AMAZON;

public class LC2340 {
    public int minimumSwaps(int[] nums) {
        if (nums.length <= 1) return 0;
        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] >= nums[maxIdx]) maxIdx = i;
        }

        if (nums[minIdx] == nums[maxIdx]) return 0;

        if (minIdx < maxIdx) {
            return minIdx + (nums.length - 1 - maxIdx);
        } else {
            return minIdx + (nums.length - 1 - maxIdx - 1);
        }
    }
}
