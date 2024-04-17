package LeetCode.BS;

public class LC153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int len = nums.length;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur < nums[len - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
