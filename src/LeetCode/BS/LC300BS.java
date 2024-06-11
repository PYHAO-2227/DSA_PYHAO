package LeetCode.BS;

public class LC300BS {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int maxL = 0;
        for (int n : nums) {
            int left = 0, right = maxL;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < n) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = n;
            maxL = Math.max(left + 1, maxL);
        }
        return maxL;
    }
}
