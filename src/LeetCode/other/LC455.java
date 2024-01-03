package LeetCode.other;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int n1 = s.length;
        int c=0;
        int i=0,j=0;

        while(i < n && j < n1){
            if(s[j] >= g[i]){
                c++;
                i++;
                j++;
            }
            else{
                j++;
            }

        }
        return c;
    }
}
