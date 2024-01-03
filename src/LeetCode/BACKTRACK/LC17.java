package LeetCode.BACKTRACK;
import java.util.*;
public class LC17 {
    String[] keypad={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        char[] dArr = digits.toCharArray();
        backtrack(dArr, 0, sb, res);
        return res;
    }

    private void backtrack(char[] dArr, int idx, StringBuilder sb, List<String> res) {
        if (idx >= dArr.length) {
            res.add(sb.toString());
            return;
        }

        int key = dArr[idx] - '0';
        for(char c : keypad[key].toCharArray())
        {
            sb.append(c);
            backtrack(dArr,idx+1,sb,res);
            sb.deleteCharAt(idx);
        }
    }
}
