package LeetCode.SlidingWindow;

public class LC76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";

        int count = 0;
        int[] mapT = new int[128];
        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            mapT[c]++;
            if (mapT[c] == 1) {
                count++;
            }
        }

        int minStart = -1;
        int minLen = Integer.MAX_VALUE;
        int[] mapS = new int[128];
        int left = 0, right = 0, num = 0;
        char[] sArr = s.toCharArray();
        while (right < m) {
            char cur = sArr[right];
            mapS[cur]++;

            if (mapT[cur] > 0 && mapS[cur] == mapT[cur]) {
                num++;
            }

            while (num == count) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char pre = s.charAt(left);
                if (mapT[pre] > 0 && mapS[pre]-- == mapT[pre]) {
                    num--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
