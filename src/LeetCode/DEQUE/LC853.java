package LeetCode.DEQUE;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        Deque<Double> stack = new ArrayDeque<Double>();
        for (int[] car : cars) {
            double time = 1.0 * (target - car[0]) / car[1];
            while (!stack.isEmpty() && stack.peek() <= time) {
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
    }
}
