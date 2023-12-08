package LeetCode.GREEDY;

public class LC670 {
    boolean flag = false;
    public boolean validPalindrome(String s) {
        char[] cArr = s.toCharArray();
        return helper(cArr, 0, s.length() - 1);
    }

    private boolean helper(char[] cArr, int left, int right) {
        if (left >= right) {
            return true;
        }
        while (left < right) {
            if (cArr[left] == cArr[right]) {
                left++;
                right--;
                continue;
            }
            if (flag == true) return false;
            flag = true;
            return helper(cArr, left + 1, right) || helper(cArr, left, right - 1);
        }
        return true;
    }
}
