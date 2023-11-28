package LeetCode.CLASSIC;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int l, int r, int k) {
        int pivot = nums[l];
        int left = l + 1, right = r;
        while (left <= right) {
            if (nums[left] <= pivot) {
                left++;
                continue;
            }
            if (nums[right] >= pivot) {
                right--;
                continue;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        swap(nums, l, right);
        if (right == nums.length - k) {
            return pivot;
        } else if (right > nums.length - k) {
            return partition(nums, l, right - 1, k);
        } else {
            return partition(nums, right + 1, r, k);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
