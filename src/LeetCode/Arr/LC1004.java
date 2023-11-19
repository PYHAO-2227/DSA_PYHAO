package LeetCode.Arr;

public class LC1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = 0, curK = k;
        while (right < nums.length) {
            int cur = nums[right];
            if (cur == 0) {
                curK--;
            }

            while (curK < 0) {
                if (nums[left] == 0) {
                    curK++;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
