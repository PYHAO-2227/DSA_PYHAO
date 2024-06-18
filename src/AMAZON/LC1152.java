package AMAZON;
import java.util.*;

public class LC1152 {
    static class Pair {
        int time;
        String web;
        public Pair (int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String user : map.keySet()) {
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(user);
            Collections.sort(list, (a,b) -> a.time - b.time);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            // make sure the right lexi order
                            res = str;
                        }
                    }
                }
            }
        }
        String[] r = res.split(" ");
        return new ArrayList<>(Arrays.asList(r));
    }
}
