package LeetCode.BS;
import java.util.*;

public class LC981 {
//    Map<String, List<Pair<Integer, String>>> map;
//
//    public LC981() {
//        map = new HashMap<>();
//    }
//
//    public void set(String key, String value, int timestamp) {
//        var list = map.get(key);
//        if (list == null) {
//            List<Pair<Integer, String>> temp = new ArrayList<>();
//            list = temp;
//            map.put(key, list);
//        }
//        Pair<Integer, String> pair = new Pair<>(timestamp, value);
//        list.add(pair);
//    }
//
//    public String get(String key, int timestamp) {
//        var list = map.get(key);
//        if (list == null || list.getFirst().getKey() > timestamp) {
//            return "";
//        }
//
//        int left = -1;
//        int right = list.size();
//        while (left != right - 1) {
//            int mid = (left + right) / 2;
//            int prev = list.get(mid).getKey();
//            if (prev <= timestamp) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//        return list.get(left).getValue();
//    }
}
