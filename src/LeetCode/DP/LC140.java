package LeetCode.DP;
import java.util.*;
public class LC140 {
    Map<Integer, List<List<String>>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        map = new HashMap<>();
        List<String> endPoint = new ArrayList<>();
        List<List<String>> end = new ArrayList<>();
        end.add(endPoint);
        map.put(s.length(), end);
        List<List<String>> comb = dp(s, 0, dict);
        List<String> res = new ArrayList<>();
        if (comb == null) return res;
        for (List<String> l : comb) {
            String temp = String.join(" ", l);
            res.add(temp);
        }
        return res;
    }

    private List<List<String>> dp(String s, int start, Set<String> dict) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<List<String>> cur = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString())) {
                List<List<String>> nxtComb = dp(s, i + 1, dict);
                for (List<String> l : nxtComb) {
                    LinkedList<String> newL = new LinkedList<>(l);
                    newL.offerFirst(sb.toString());
                    cur.add(newL);
                }
            }
        }
        map.put(start, cur);
        return cur;
    }
}
