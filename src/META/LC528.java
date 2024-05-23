package META;


import java.util.Random;

public class LC528 {
    Random random;
    int[] preSum;
    int sum = 0;
    public LC528(int[] w) {
        this.random = new Random();
        int len = w.length;
        preSum = new int[len];
        for (int i = 0; i < len; i++) {
            sum += w[i];
            if (i == 0) {
                preSum[0] = w[0];
            } else {
                preSum[i] = preSum[i - 1] + w[i];
            }
        }
    }

    public int pickIndex() {
        int seed = random.nextInt(sum) + 1;
        return bs(preSum, seed);
    }

    private int bs(int[] preSum, int seed) {
        int left = 0, right = preSum.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(preSum[mid] == seed)
                return mid;
            else if(preSum[mid] < seed)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
