package META;

/*408. Valid Word Abbreviation
* A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.*/
public class LC408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wArr = word.toCharArray();
        char[] sArr = abbr.toCharArray();

        int l = 0, r = 0;
        int count = 0;
        while (l < wArr.length && r < sArr.length) {
            if (Character.isDigit(sArr[r])) {
                if (sArr[r] == '0' && count == 0) { // 数字不能以0开头
                    return false;
                }
                count = count * 10 + (sArr[r] - '0');
                r++;
            } else {
                l += count;
                if (l >= wArr.length || wArr[l] != sArr[r]) {
                    return false;
                }
                l++;
                r++;
                count = 0;
            }
        }
        l += count; // 应用最后的count值
        return l == wArr.length && r == sArr.length;
    }
}
