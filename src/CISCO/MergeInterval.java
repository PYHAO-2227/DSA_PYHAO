package CISCO;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    public int[][] merge(int[][] in) {
        Arrays.sort(in, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<int[]>();
        for(int i = 0; i < in.length; i++){
            if(ans.isEmpty()){
                ans.add(in[0]);
                continue;
            }
            if(ans.get(ans.size()-1)[1] >= in[i][0]){
                if(ans.get(ans.size()-1)[1] < in[i][1]){
                    ans.get(ans.size()-1)[1] = in[i][1];
                }
            }
            else{
                ans.add(in[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
