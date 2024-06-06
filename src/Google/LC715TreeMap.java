package Google;
import java.util.*;
class LC715TreeMap {
    TreeMap<Integer, Integer> map;
    public LC715TreeMap() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> l = map.floorEntry(left);
        Map.Entry<Integer, Integer> r = map.floorEntry(right);
        if (l != null && l.getValue() >= left) {
            left = l.getKey();
        }

        if (r != null && r.getValue() > right) {
            right = r.getValue();
        }
        map.subMap(left, right).clear();
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> cur = map.floorEntry(left);
        return cur != null && cur.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> l = map.floorEntry(left);
        Map.Entry<Integer, Integer> r = map.floorEntry(right);

        if (l != null && l.getValue() > left) {
            map.put(l.getKey(), left);
        }

        if (r != null && r.getValue() > right) {
            map.put(right, r.getValue());
        }

        map.subMap(left, right).clear();

    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
