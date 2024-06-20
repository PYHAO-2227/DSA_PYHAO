package LeetCode.DAC;

import java.util.ArrayList;
import java.util.List;

public class LC315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int[] count = new int[nums.length];
        int[] idxs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) idxs[i] = i;
        dac(idxs, nums, count, 0, nums.length - 1);
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void dac(int[] idxs, int[] nums, int[] count, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        dac(idxs, nums, count, left, mid);
        dac(idxs, nums, count, mid + 1, right);

        int p1 = left, p2 = mid + 1;
        while (p1 <= mid) {
            while (p2 <= right && nums[idxs[p1]] > nums[idxs[p2]]) {
                p2++;
            }
            count[idxs[p1]] += p2 - mid - 1;
            p1++;
        }

        int[] sorted = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                sorted[k++] = idxs[j++];
            } else if (j > right) {
                sorted[k++] = idxs[i++];
            } else {
                if (nums[idxs[i]] < nums[idxs[j]]) {
                    sorted[k++] = idxs[i++];
                } else {
                    sorted[k++] = idxs[j++];
                }
            }
        }

        for (int t = 0; t < sorted.length; t++) {
            idxs[left + t] = sorted[t];
        }
    }
}
