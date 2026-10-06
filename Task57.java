class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length,count=0; boolean[] seen=new boolean[n];
        for(int i=0;i<n;i++) if(!seen[i]) { count++; dfs(isConnected,seen,i); }
        return count;
    }
    private void dfs(int[][] g,boolean[] seen,int u){
        seen[u]=true;
        for(int v=0;v<g.length;v++) if(g[u][v]==1&&!seen[v]) dfs(g,seen,v);
    }
}
