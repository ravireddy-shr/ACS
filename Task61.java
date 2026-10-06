import java.util.*;
class Solution {
    public int[] findOrder(int n,int[][] prerequisites){
        List<List<Integer>> g=new ArrayList<>(); int[] in=new int[n];
        for(int i=0;i<n;i++)g.add(new ArrayList<>());
        for(int[] p:prerequisites){g.get(p[1]).add(p[0]);in[p[0]]++;}
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++)if(in[i]==0)q.offer(i);
        int[] ans=new int[n]; int k=0;
        while(!q.isEmpty()){int u=q.poll();ans[k++]=u;for(int v:g.get(u))if(--in[v]==0)q.offer(v);}
        return k==n?ans:new int[0];
    }
}
