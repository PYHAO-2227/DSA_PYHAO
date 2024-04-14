package LeetCode.SlidingWindow;

public class LC424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() <= k) return k;

        int[] map = new int[256];
        char[] sArr = s.toCharArray();
        int peakCount = 0;
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            char cur = sArr[right];
            map[cur]++;
            if (map[cur] > peakCount) {
                peakCount = map[cur];
            }
            if (right - left + 1 > peakCount + k) {
                map[sArr[left]]--;
                left++;
            }
        }
        return right - left;
    }
}
