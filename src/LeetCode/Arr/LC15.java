package LeetCode.Arr;
import java.util.*;
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        while (left <= len - 3) {
            int curStart = nums[left];
            int mid  = left + 1, right = len - 1;
            while (mid < right) {
                int sum = curStart + nums[mid] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(curStart);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (mid + 1 < right && nums[mid + 1] == nums[mid]) {
                        mid++;
                    }
                    mid++;
                    while (right - 1 > left && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
            while (left <= len - 3 && nums[left + 1] == nums[left]) {
                left++;
            }
            left++;
        }
        return res;
    }
}
