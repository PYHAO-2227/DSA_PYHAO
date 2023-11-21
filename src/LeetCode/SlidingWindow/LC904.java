package LeetCode.SlidingWindow;

public class LC904 {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        if (len <= 2) {
            return len;
        }

        int res = 0;
        int left = 0, right = 0, count = 0;
        int[] map = new int[len + 1];
        while (right < len) {
            int cur = fruits[right];
            map[cur]++;

            if (map[cur] == 1) {
                count++;
            }

            while (count > 2) {
                int pre = fruits[left];
                left++;
                map[pre]--;
                if (map[pre] == 0) {
                    count--;
                }
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
