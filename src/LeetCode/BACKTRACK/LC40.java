package LeetCode.BACKTRACK;
import java.util.*;

public class LC40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] can, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < can.length; i++) {
            if (i > start && can[i] == can[i-1]) continue;
            int cur = can[i];
            if (cur > target) break;
            track.addLast(cur);
            backtrack(can, i + 1, target - cur);
            track.removeLast();
        }
        return;
    }
}
