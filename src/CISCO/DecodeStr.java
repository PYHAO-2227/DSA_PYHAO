package CISCO;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStr {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack_num = new ArrayDeque<>();
        Deque<String> stack_str = new ArrayDeque<>();
        char[] sArr = s.toCharArray();
        int len = sArr.length;

        int num = 0;
        for(char c : sArr) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (int)(c - '0');
            } else if (c == '[') {
                stack_str.offerLast(res.toString());
                stack_num.offerLast(num);
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                int preNum = stack_num.pollLast();
                String preStr = stack_str.pollLast();
                sb.append(preStr);
                for (int i = 0; i < preNum; i++) {
                    sb.append(res);
                }
                res = sb;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
