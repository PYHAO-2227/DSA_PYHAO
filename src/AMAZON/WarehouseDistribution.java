package AMAZON;

public class WarehouseDistribution {
    public long findMinimumOperations(int[] boxes) {
        // write your code here
        int len = boxes.length;
        int sum = 0;
        for (int num : boxes) {
            sum += num;
        }

        int modRes = sum % len;
        int avg = sum / len;

        int count = 0;
        for (int i = 0; i < len; i++) {
            int cur = boxes[i];
            if (cur <= avg) continue;

            if (modRes > 0) {
                count += cur - avg - 1;
                modRes--;
            } else {
                count += cur - avg;
            }
        }
        return count;
    }

}
