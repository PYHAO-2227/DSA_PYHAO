package LeetCode.BS;

public class LC287BS {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
