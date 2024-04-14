package LeetCode.Arr;

public class LC121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if (cur < minPrice) {
                minPrice = cur;
            } else {
                res = Math.max(cur - minPrice, res);
            }
        }
        return res;
    }
}
