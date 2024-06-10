package LeetCode.BinaryIndexedTree;

public class LC307 {
    int[] tree;
    int n;
    int[] nums;
    int lowbit(int x) {
        return x&-x;
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) res += tree[i];
        return res;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    public LC307(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
