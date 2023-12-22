package LeetCode.CLASSIC;
import java.util.*;
public class LC295 {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public LC295() {
        small = new PriorityQueue<>((a,b)->b-a);
        large = new PriorityQueue<>((a,b)->a-b);
    }

    public void addNum(int num) {
        if (small.isEmpty()) {
            small.add(num);
            return;
        }

        int l = small.size(), r = large.size();
        if (l == r) {
            if (num <= large.peek()) {
                small.add(num);
            } else {
                small.add(large.poll());
                large.add(num);
            }
        } else {
            if (num >= small.peek()) {
                large.add(num);
            } else {
                large.add(small.poll());
                small.add(num);
            }
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            double res = (small.peek() + large.peek()) / 2.0;
            return res;
        } else {
            return small.peek();
        }
    }
}
