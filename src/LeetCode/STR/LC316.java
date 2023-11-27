package LeetCode.STR;

public class LC316 {
    public String removeDuplicateLetters(String s) {
        char[] sArr = s.toCharArray();
        int[] count = new int[128];
        for (char c : sArr) {
            count[c]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] inSb = new boolean[128];
        int size = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cur = sArr[i];
            count[cur]--;
            if (inSb[cur]) {
                continue;
            }

            while (size > 0 && sb.charAt(size - 1) > cur) {
                char pre = sb.charAt(size - 1);
                if (count[pre] == 0) {
                    break;
                }
                sb.deleteCharAt(size - 1);
                inSb[pre] = false;
                size--;
            }

            sb.append(cur);
            inSb[cur] = true;
            size++;
        }

        return sb.toString();
    }
}
