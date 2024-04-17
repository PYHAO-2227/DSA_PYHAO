package LeetCode.Arr;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
