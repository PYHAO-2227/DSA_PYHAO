import java.util.Arrays;

public class BoxInBox {
    public BoxInBox() {
    }
    private int[] dp;
    private boolean[] done;
    public int dpCount(int[] boxes) {
        int len = boxes.length;
        dp = new int[len];
        done = new boolean[len];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            if (done[i]) {
                continue;
            }
            dp[i] = helper(boxes, i);
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int helper(int[] boxes, int i) {
        if (done[i]) {
            return dp[i];
        }
        for (int j = 0; j < boxes.length; j++) {
            if (j == i) {
                continue;
            } else if (fits(boxes[j], boxes[i])) {
                dp[i] = Math.max(dp[i], helper(boxes, j) + 1);
            } else {
                continue;
            }
        }
        done[i] = true;
        return dp[i];
    }

    private boolean fits(int i, int j) {
        return i < j;
    }


}
