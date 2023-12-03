package LeetCode.BS;

public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur != nums[mid - 1] && cur != nums[mid + 1]) {
                return cur;
            }

            if ((mid & 1) == 0) {
                // mid is even
                if (cur == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid - 2;
                }
            } else {
                if (cur == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }
}
