package LeetCode.DAC;

public class LC493 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return dac(nums, 0, nums.length - 1);
    }

    private int dac(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) >> 1;
        int r1 = dac(nums, left, mid);
        int r2 = dac(nums, mid + 1, right);
        int res = r1 + r2;

        int i = left;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            res += j - mid - 1;
            i++;
        }

        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = nums[p2++];
            } else if (p2 > right) {
                sorted[p++] = nums[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    sorted[p++] = nums[p1++];
                } else {
                    sorted[p++] = nums[p2++];
                }
            }
        }

        for (int k = 0; k < sorted.length; k++) {
            nums[left + k] = sorted[k];
        }
        return res;
    }
}
