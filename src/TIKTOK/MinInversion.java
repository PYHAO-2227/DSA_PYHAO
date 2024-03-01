package TIKTOK;

import java.util.*;

public class MinInversion {
    public long findMinCost(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            l.add(num); // 将数组转换为列表
        }

        long an = 0, ban = 0; // an 用于存储最终结果的二进制表示，ban 存储最小成本
        Map<Integer, List<Integer>> ar = new HashMap<>(); // Trie 存储结构
        ar.put(0, l); // 初始时，所有元素都在根节点下
        int xo = 1 << 30; // 从最高位开始考虑

        for (int i = 30; i >= 0; i--) {
            long a = 0, b = 0; // a 和 b 分别存储当前位为 0 和 1 时的成本
            Map<Integer, List<Integer>> pr = new HashMap<>(); // 下一层的 Trie 结构

            for (Map.Entry<Integer, List<Integer>> entry : ar.entrySet()) {
                int ff = entry.getKey();
                List<Integer> j = entry.getValue();
                long aa = 0, bb = 0; // aa 和 bb 分别累加当前位为 0 和 1 的成本
                long oo = 0, zz = 0; // oo 和 zz 分别计数当前位为 1 和 0 的数量

                for (int x = 0; x < j.size(); x++) {
                    if ((j.get(x) & xo) != 0) {
                        aa += zz;
                        oo++;
                        pr.computeIfAbsent(2 * ff, k -> new ArrayList<>()).add(j.get(x));
                    } else {
                        bb += oo;
                        zz++;
                        pr.computeIfAbsent(2 * ff + 1, k -> new ArrayList<>()).add(j.get(x));
                    }
                }
                a += aa;
                b += bb;
            }
            ar = pr;
            if (a < b) {
                an += xo; // 选择使得成本最小的分支
                ban += a;
            } else {
                ban += b;
            }
            xo >>= 1; // 移动到下一位
        }
//        return new long[]{ban, an}; // 返回最小成本和最优解X

        return ban; // 返回最小成本和最优解X
    }
    /*#include <bits/stdc++.h>
using namespace std;
#define ll long long
const int maxn=5e6+5,maxm=2e4+5,inf=0x3f3f3f3f,mod=1e9+7;
int ch[maxn][2],sz[maxn],id,n;
ll dp[30][2];
void add(int x){
    int p=0;
    for(int i=29;~i;i--){
        int v=(x>>i)&1;
        if(!ch[p][v])ch[p][v]=++id;
        dp[i][v^1]+=sz[ch[p][v^1]];
        p=ch[p][v],sz[p]++;
    }
}
int main(){
    cin>>n;
    for(int i=1;i<=n;i++){
        int x;cin>>x;add(x);
    }
    ll cnt=0,ans=0;
    for(int i=29;~i;i--){
        if(dp[i][0]<dp[i][1])ans+=(1<<i),cnt+=dp[i][0];
        else cnt+=dp[i][1];
    }
    printf("%lld %lld\n",cnt,ans);
}*/
}
