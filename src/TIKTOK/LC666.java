package TIKTOK;

import java.util.Arrays;

public class LC666 {
        int[] tree = new int[31];
        int res = 0;
        public int pathSum(int[] nums) {
            Arrays.fill(tree, -1);
            for (int num : nums) {
                helper(num);
            }
            dfs(0, 0);
            return res;
        }

        private void helper(int num) {
            int temp = num / 10;
            int layer = temp / 10;
            int pos = temp % 10;
            int val = num % 10;
            int idx = ((1 << (layer - 1)) - 1) + (pos - 1);
            tree[idx] = val;
        }

        private void dfs(int idx, int sum) {
            if (idx > tree.length - 1 || tree[idx] == -1) {
                return;
            }
            sum += tree[idx];
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            if ((left > tree.length - 1 || tree[left] == -1) && (right > tree.length - 1 || tree[right] == -1)) {
                res += sum;
            } else {
                dfs(left, sum);
                dfs(right, sum);
            }
        }
}
