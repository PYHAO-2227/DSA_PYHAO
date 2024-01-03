package LeetCode.other;

public class LC926 {
    int[] dp0;
    int[] dp1;
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        dp0 = new int[len + 1];
        dp1 = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            char cur = arr[i-1];
            if (cur == '0') {
                dp0[i] = dp0[i - 1];
                dp1[i] = Math.min(dp1[i - 1], dp0[i - 1]) + 1;
            } else {
                dp0[i] = dp0[i - 1] + 1;
                dp1[i] = Math.min(dp0[i - 1], dp1[i - 1]);
            }
        }

        return Math.min(dp1[len], dp0[len]);
    }
}
