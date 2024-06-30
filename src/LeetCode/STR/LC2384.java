package LeetCode.STR;

public class LC2384 {
    public String largestPalindromic(String num) {
        int len = num.length();
        char[] cArr = num.toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < len; i++) {
            count[cArr[i] - '0']++;
        }
        StringBuilder half = new StringBuilder();
        for (int i = 9; i >=  0; i--) {
            if (count[i] == 0) continue;
            for (int k = 0; k < count[i] / 2; k++) {
                half.append(i + "");
            }
            count[i] = count[i] % 2;
        }

        String left = half.toString();
        if (left.length() > 0 && left.charAt(0) == '0') half = new StringBuilder();

        StringBuilder mid = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (count[i] == 1) {
                mid.append(i + "");
                break;
            }
        }
        String res = half.toString() + mid.toString() + half.reverse().toString();
        if (res.length() == 0 || res.charAt(0) == 0) {
            return "0";
        } else {
            return res;
        }
    }
}
