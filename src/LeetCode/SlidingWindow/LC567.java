package LeetCode.SlidingWindow;

import java.util.Arrays;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] map1 = new int[128];
        for (char c : s1.toCharArray()) {
            map1[c]++;
        }

        int left = 0, right = 0;
        char[] s2Arr = s2.toCharArray();
        int[] map2 = new int[128];
        while(right < s2.length()) {
            char cur = s2Arr[right];

            if (map1[cur] == 0) {
                right++;
                left = right;
                Arrays.fill(map2, 0);
                continue;
            }

            map2[cur]++;

            if (map2[cur] == map1[cur] && (right - left) + 1 == s1.length()) {
                return true;
            }

            if (map2[cur] <= map1[cur]) {
                right++;
            } else {
                while(s2Arr[left] != cur) {
                    map2[s2Arr[left]]--;
                    left++;
                }
                left++;
                map2[cur]--;
                right++;
            }

        }
        return false;

    }
}
