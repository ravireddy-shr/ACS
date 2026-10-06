import java.util.*;
class Solution {
    public int[] shortestAlternatingPaths(int n,int[][] redEdges,int[][] blueEdges){
        List<Integer>[][] g=new ArrayList[2][n];
        for(int c=0;c<2;c++)for(int i=0;i<n;i++)g[c][i]=new ArrayList<>();
        for(int[] e:redEdges)g[0][e[0]].add(e[1]);
        for(int[] e:blueEdges)g[1][e[0]].add(e[1]);
        int[][] d=new int[2][n];Arrays.fill(d[0],-1);Arrays.fill(d[1],-1);
        Queue<int[]> q=new ArrayDeque<>();q.offer(new int[]{0,0});q.offer(new int[]{0,1});d[0][0]=d[1][0]=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();int u=cur[0],last=cur[1],next=1-last;
            for(int v:g[next][u])if(d[next][v]==-1){d[next][v]=d[last][u]+1;q.offer(new int[]{v,next});}
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++)ans[i]=d[0][i]==-1?d[1][i]:d[1][i]==-1?d[0][i]:Math.min(d[0][i],d[1][i]);
        return ans;
    }
}
