package META;
/*1249. Minimum Remove to Make Valid Parentheses
* Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.*/
public class LC1249_1 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        int countL = 0, countR = 0; // count of ( )
        for(int i = 0; i < sArr.length; i++) {
            char cur = sArr[i];
            if (cur == ')') {
                if ((countL - countR) <= 0) {
                    continue;
                } else {
                    sb.append(cur);
                    countR++;
                }
            } else if (cur == '(') {
                sb.append(cur);
                countL++;
            } else {
                sb.append(cur);
            }
        }

        if (countL == countR) {
            return sb.toString();
        } else {
            int gap = countL - countR;
            for (int i = sb.length() - 1; i >= 0 && gap > 0; i--) {
                if (sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    gap--;
                }
            }
            return sb.toString();
        }
    }
}
