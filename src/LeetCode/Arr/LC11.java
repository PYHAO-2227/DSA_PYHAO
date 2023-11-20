package LeetCode.Arr;

public class LC11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * width;
            max = Math.max(max, area);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
