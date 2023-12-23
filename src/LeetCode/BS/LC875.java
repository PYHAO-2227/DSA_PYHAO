package LeetCode.BS;

public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int total = 0, max = -1;
        for (int n : piles) {
            total += n;
            max = Math.max(max, n);
        }
        int min = total / h;
        if (min < 1) min = 1;

        int left = min, right = max;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int time = calculateSum(piles, mid);
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (calculateSum(piles, left) <= h) {
            return left;
        } else {
            return right;
        }
    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
