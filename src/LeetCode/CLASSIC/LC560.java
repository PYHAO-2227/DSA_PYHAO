package LeetCode.CLASSIC;

import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        int preSum = 0, count = 0;
        preSumFreq.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
