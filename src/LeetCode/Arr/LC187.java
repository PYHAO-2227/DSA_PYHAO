package LeetCode.Arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return ans;
        }
        Set<String> res = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        int left = 0, right = 9;
        while (right < s.length()) {
            String cur = s.substring(left, right + 1);
            if (set.contains(cur)) {
                res.add(cur);
            } else {
                set.add(cur);
            }
            left++;
            right++;
        }

        for (String str : res) {
            ans.add(str);
        }
        return ans;
    }
}
