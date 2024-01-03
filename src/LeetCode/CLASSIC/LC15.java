package LeetCode.CLASSIC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) return a;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if(nums[i]+nums[j]+nums[k]<0)
                    j++;
                else if(nums[i]+nums[j]+nums[k]>0)
                    k--;
                else{
                    a.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j+1<=k&&nums[j]==nums[j+1])
                        j++;
                    j++;k--;
                }

            }
            while(i+1<n&&nums[i]==nums[i+1])
                i++;
        }
        return a;
    }
}
