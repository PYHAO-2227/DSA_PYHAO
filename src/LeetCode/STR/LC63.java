package LeetCode.STR;
import java.util.*;
public class LC63 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String id = getId(s);
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(s);
        }

        for (String id : map.keySet()) {
            res.add(map.get(id));
        }

        return res;
    }

    private String getId(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
