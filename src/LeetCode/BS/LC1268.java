package LeetCode.BS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int len = products.length;
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            bs(prefix, products, res);
        }
        return res;
    }

    private void bs(String prefix, String[] products, List<List<String>> res) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefix.compareTo(products[mid]) <= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        List<String> temp = new ArrayList<>();

        if (left < 0 || left >= products.length) {
            res.add(temp);
            return;
        }

        if (prefix.compareTo(products[left]) <= 0) {
            for (int j = left; j <= Math.min(products.length - 1, left + 2); j++) {
                if (products[j].length() < prefix.length()) break;
                if (!products[j].substring(0, prefix.length()).equals(prefix)) break;
                temp.add(products[j]);
            }
        }
        res.add(temp);
        return;
    }
}
