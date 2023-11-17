import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        LIS lis = new LIS();
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lis.lengthOfLIS(height);
    }
}
