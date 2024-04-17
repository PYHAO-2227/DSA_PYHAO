package LeetCode.Arr;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0, len = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            len = 1;
            int cur = num;
            while (set.contains(cur + 1)) {
                cur = cur + 1;
                len++;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
