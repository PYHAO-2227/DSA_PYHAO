package LeetCode.other;

public class LC91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] memo = new int[len + 1];
        memo[0] = 1;
        char[] arr = s.toCharArray();

        for (int i = 1; i <= len; i++) {
            int count = 0;

            int cur = arr[i - 1] - '0';

            if (cur != 0) {
                count += memo[i - 1];
            }

            if (i > 1) {
                int pre = arr[i -2] - '0';
                int temp = 10 * pre + cur;
                if (temp <= 26 && temp >= 10) {
                    count += memo[i - 2];
                }
            }

            memo[i] = count;
        }

        return memo[len];

    }
}
