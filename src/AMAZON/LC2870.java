package AMAZON;

import java.util.HashMap;
import java.util.Map;

public class LC2870 {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        for (int val : map.values()) {
            int temp = findMin(val);
            if (temp == -1) return -1;
            res += temp;
        }
        return res;
    }

    private int findMin(int count) {
        int maxThree = count / 3;
        for (int i = maxThree; i >= 0; i--) {
            if ((count - i * 3) % 2 == 0) {
                return i + (count - i * 3) / 2;
            }
        }
        return -1;
    }
}
