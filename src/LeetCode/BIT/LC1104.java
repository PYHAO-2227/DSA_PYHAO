package LeetCode.BIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        while (label > 0) {
            ans.add(label);
            label >>= 1;
        }

        Collections.reverse(ans);
        int l, r, layer = ans.size();
        for (int i = 0; i < layer; i++) {
            if ((layer & 1) != (i & 1)) continue;
            l = (1 << i);
            r = l + l - 1;
            ans.set(i, r - ans.get(i) + l);
        }
        return ans;
    }
}
