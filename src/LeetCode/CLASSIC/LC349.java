package LeetCode.CLASSIC;

import java.util.HashSet;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> inter = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if (set.contains(nums2[i])){
                inter.add(nums2[i]);
            }
        }
        int[] res = new int[inter.size()];
        int i =0;
        for(int ele:inter){
            res[i++] = ele;
        }
        return res;

    }
}
