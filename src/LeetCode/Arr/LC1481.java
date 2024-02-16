package LeetCode.Arr;

import java.util.*;

public class LC1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> occurrences = new ArrayList<>(countMap.values());
        Collections.sort(occurrences);

        int uniqueCount = countMap.size();
        int removed = 0;
        int index = 0;

        while (removed < k && index < occurrences.size()) {
            int count = occurrences.get(index);
            if (count <= k - removed) {
                uniqueCount--;
                removed += count;
            } else {
                break;
            }
            index++;
        }

        return uniqueCount;
    }
}
