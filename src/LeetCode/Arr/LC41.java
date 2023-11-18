package LeetCode.Arr;

public class LC41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            } else {
                int idx = nums[i] - 1;
                if (idx >= nums.length - 1 || idx < 0) {
                    i++;
                    continue;
                } else {
                    if (nums[idx] == idx + 1) {
                        i++;
                        continue;
                    }
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }
        }

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }
}
