package LeetCode;

import java.util.*;

public class LC398 {
    Map<Integer, List<Integer>> map;
    Random r;
    public LC398(int[] nums) {
        map = new HashMap<>();
        r = new Random();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                map.get(cur).add(i);
            } else {
                List<Integer> idxArr = new ArrayList<>();
                idxArr.add(i);
                map.put(cur, idxArr);
            }
        }
    }

    public int pick(int target) {
        List<Integer> idxArr = map.get(target);
        int len = idxArr.size();
        int pick = r.nextInt(len);
        return idxArr.get(pick);
    }
}
