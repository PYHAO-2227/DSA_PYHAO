package LeetCode.DEQUE;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC907 {
    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵
        for (int r = 0; r <= arr.length; ++r) {
            int x = r < arr.length ? arr[r] : -1; // 假设 arr 末尾有个 -1
            while (st.size() > 1 && arr[st.peek()] >= x) {
                int i = st.pop();
                ans += (long) arr[i] * (i - st.peek()) * (r - i); // 累加贡献
            }
            st.push(r);
        }
        return (int) (ans % MOD);
    }
}
