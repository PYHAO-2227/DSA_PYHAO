package META;

import java.util.HashMap;
import java.util.Map;

public class LC1570 {
    Map<Integer, Integer> map;
    int size = 0;
    LC1570(int[] nums) {
        map = new HashMap<>();
        size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
                size++;
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(LC1570 vec) {
        Map<Integer, Integer> smaller = this.map;
        Map<Integer, Integer> bigger = vec.map;
        if (vec.size <= this.size) {
            smaller = vec.map;
            bigger = this.map;
        }
        int res = 0;
        for (int i : smaller.keySet()) {
            res += smaller.get(i) * bigger.getOrDefault(i, 0);
        }
        return res;
    }
}
