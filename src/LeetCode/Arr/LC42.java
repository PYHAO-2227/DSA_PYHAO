package LeetCode.Arr;

public class LC42 {
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = 0;
        int[] rightMax = new int[len];
        rightMax[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int j = len - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }

        for (int i = 0; i < len; i++) {
            if (leftMax[i] <= height[i] || rightMax[i] <= height[i]) {
                continue;
            } else {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return res;
    }
}
