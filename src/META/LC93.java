package META;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backtrack(s, 0, 0, "");
        return res;
    }

    private void backtrack(String s, int start, int count, String path) {
        if (count == 4) {
            if (start == s.length()) res.add(path.substring(0, path.length() - 1));
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String cur = s.substring(start, start + i);
            if (cur.length() > 1 && cur.startsWith("0") || Integer.parseInt(cur) > 255) continue;
            backtrack(s, start + i, count + 1, path + cur + ".");
        }
    }
}
