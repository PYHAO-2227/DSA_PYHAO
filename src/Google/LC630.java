package Google;
import java.util.*;
public class LC630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int time = 0;
        int count = 0;
        for(int[] c : courses){
            if(c[0]+ time <= c[1]){
                pq.add(c[0]);
                time += c[0];
                count++;
            }
            else if(!pq.isEmpty() && pq.peek() > c[0]){
                time += c[0] - pq.remove();
                pq.add(c[0]);
            }
        }
        return count;
    }
}
