package LeetCode.other;

public class LC1217 {
    public int minCostToMoveChips(int[] position) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                evenSum += 1;
            } else {
                oddSum += 1;
            }
        }
        return Math.min(oddSum, evenSum);
    }
}
