package TIKTOK;

import java.util.Arrays;

public class findMinProdSum {
    public int findRes(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int[] newArr = new int[len];
        int l = 0, r = len - 1;
        int s = 0, b = len - 1;
        while (s < b) {
            newArr[l] = arr[b];
            l++;
            b--;
            newArr[r] = arr[b];
            r--;
            b--;
            if (l >= r) {
                break;
            }
            newArr[l] = arr[s];
            l++;
            s++;
            newArr[r] = arr[s];
            r--;
            s++;
        }
        if (l == r) {
            newArr[l] = arr[s];
        }
        System.out.println(Arrays.toString(newArr));
        return findSum(newArr);
    }

    private int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i] * arr[i + 1];
        }
        return sum;
    }
}
