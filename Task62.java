import java.util.*;
class Solution {
    public int[] sortItems(int n,int m,int[] group,List<List<Integer>> beforeItems){
        for(int i=0;i<n;i++)if(group[i]==-1)group[i]=m++;
        List<List<Integer>> ig=new ArrayList<>(),gg=new ArrayList<>();
        for(int i=0;i<n;i++)ig.add(new ArrayList<>());
        for(int i=0;i<m;i++)gg.add(new ArrayList<>());
        int[] ii=new int[n],gi=new int[m];
        for(int i=0;i<n;i++)for(int p:beforeItems.get(i)){
            ig.get(p).add(i);ii[i]++;
            if(group[p]!=group[i]){gg.get(group[p]).add(group[i]);gi[group[i]]++;}
        }
        List<Integer> io=topo(ig,ii),go=topo(gg,gi);
        if(io.size()!=n||go.size()!=m)return new int[0];
        List<List<Integer>> by=new ArrayList<>();
        for(int i=0;i<m;i++)by.add(new ArrayList<>());
        for(int x:io)by.get(group[x]).add(x);
        int[] ans=new int[n];int k=0;
        for(int g:go)for(int x:by.get(g))ans[k++]=x;
        return ans;
    }
    private List<Integer> topo(List<List<Integer>> g,int[] in){
        Queue<Integer> q=new ArrayDeque<>();List<Integer> o=new ArrayList<>();
        for(int i=0;i<in.length;i++)if(in[i]==0)q.offer(i);
        while(!q.isEmpty()){int u=q.poll();o.add(u);for(int v:g.get(u))if(--in[v]==0)q.offer(v);}
        return o;
    }
}
