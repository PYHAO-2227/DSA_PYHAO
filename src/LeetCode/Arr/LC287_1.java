package LeetCode.Arr;

public class LC287_1 {
    // 二分查找法
    public int findDuplicate(int[] nums) {
        int len = nums.length;

        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
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
