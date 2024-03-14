package CISCO;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] sArr = s.toCharArray();
        int len = s.length();
        int maxLeft = -1, maxRight = -1, max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i, right = i + j;

                while (left >=0 && right < len && sArr[left] == sArr[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;

                if (max < right - left + 1) {
                    maxLeft = left;
                    maxRight = right;
                    max = right - left + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}
