package LeetCode.STR;

import java.util.Stack;

public class LC1249 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int len = s.length();
        char[] sArr = s.toCharArray();
        boolean[] bad = new boolean[len];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            char cur = sArr[i];
            if (cur != '(' && cur != ')') continue;
            if (cur == '(') {
                st.push(i);
            }
            if (cur == ')') {
                if (st.isEmpty()) {
                    st.push(i);
                    continue;
                }

                char pre = sArr[st.peek()];
                if (pre == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }

        while (!st.isEmpty()) {
            int idx = st.pop();
            bad[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (bad[i]) continue;
            sb.append(sArr[i]);
        }

        return sb.toString();
    }
}
