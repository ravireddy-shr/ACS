class Solution {
    public int numIslands(char[][] grid){
        int ans=0;
        for(int r=0;r<grid.length;r++)for(int c=0;c<grid[0].length;c++)if(grid[r][c]=='1'){ans++;dfs(grid,r,c);}
        return ans;
    }
    private void dfs(char[][] g,int r,int c){
        if(r<0||r>=g.length||c<0||c>=g[0].length||g[r][c]!='1')return;
        g[r][c]='0';dfs(g,r+1,c);dfs(g,r-1,c);dfs(g,r,c+1);dfs(g,r,c-1);
    }
}
