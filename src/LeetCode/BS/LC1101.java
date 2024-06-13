package LeetCode.BS;

public class LC1101 {
    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] ws, int days, int x) {
        int count = 1;
        int curLoad = 0;
        for (int w : ws) {
            if (curLoad + w > x) {
                count++;
                curLoad = w;
            } else {
                curLoad += w;
            }
        }
        return count <= days;
    }
}
