package AMAZON;

import java.util.HashMap;

public class DiscountPairs {
    public int getDiscountPairs(int x, int[] price) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = price.length;
        for (int  i = 0; i < len; i++) {
            int cur = price[i];
            int modRes = cur % x;
            map.put(modRes, map.getOrDefault(modRes, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int modRes = price[i] % x;
            map.put(modRes, map.get(modRes) - 1);

            if (map.containsKey(x - modRes)) {
                res += map.get(x - modRes);
            }
        }
        return res;
    }

    public int getDiscountPairs1(int x, int[] price) {
        int count = 0;
        int[] freq = new int[x];

        for (int p: price){
            freq[p%x]++;
        }

        count += freq[0] * (freq[0] - 1) / 2;

        for (int i = 1; i <= x - i; i++){
            if (i != x - i){
                count += freq[i] * (freq[x-i]);
            }else{
                count += freq[i] * (freq[i] - 1) / 2;
            }
        }
        return count;
        // 1 + ... (x-1) = [1 + (x-1)] * (x-1) / 2
    }
}
