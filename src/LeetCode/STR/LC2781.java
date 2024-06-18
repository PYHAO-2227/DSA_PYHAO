package LeetCode.STR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> fw = new HashSet<>(forbidden);
        int left = 0, right = 0, max = 0;
        int len = word.length();
        for (; right < len; right++) {
            for (int j = right; j >= left && j > right - 10; j--) {
                if (fw.contains(word.substring(j, right + 1))) {
                    left = j + 1;
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
