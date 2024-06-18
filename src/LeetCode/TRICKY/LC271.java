package LeetCode.TRICKY;

import java.util.ArrayList;
import java.util.List;

public class LC271 {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        while (idx < s.length()) {
            int nxt = s.indexOf('/', idx);
            int len = Integer.parseInt(s.substring(idx, nxt));
            res.add(s.substring(nxt + 1, nxt + len + 1));
            idx = nxt + len + 1;
        }
        return res;
    }
}
