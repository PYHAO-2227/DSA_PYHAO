package LeetCode.STR;

public class LC402 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) {
            return "0";
        }
        int count = k;
        StringBuilder sb = new StringBuilder();
        int size = 0;
        char[] nums = num.toCharArray();
        for (int i = 0; i < len; i++) {
            char cur = nums[i];
            while (size > 0 && k > 0 && sb.charAt(size - 1) > cur) {
                sb.deleteCharAt(size - 1);
                size--;
                k--;
            }
            sb.append(cur);
            size++;
        }

        String last = sb.substring(0, len - count);
        int j = 0;
        while (j < last.length() - 1 && last.charAt(j) == '0') {
            j++;
        }
        return last.substring(j);

    }
}
