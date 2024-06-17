package LeetCode.BS;

import java.util.Arrays;

public class LC475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int len = houses.length;
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int closeH = bs(heaters, houses[i]);
            res = Math.max(res, Math.abs(heaters[closeH] - houses[i]));
        }
        return res;
    }

    private int bs(int[] heaters, int pos) {
        if (pos <= heaters[0]) return 0;
        int len = heaters.length;
        if (pos >= heaters[len - 1]) return len - 1;

        int left = 0, right = len - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == pos) {
                return mid;
            } else if (heaters[mid] > pos) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return Math.abs(heaters[left] - pos) <= Math.abs(heaters[right] - pos) ? left : right;
    }
}
