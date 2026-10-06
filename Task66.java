class Solution {
    public int[][] floodFill(int[][] image,int sr,int sc,int color){
        int old=image[sr][sc];if(old==color)return image;dfs(image,sr,sc,old,color);return image;
    }
    private void dfs(int[][] g,int r,int c,int old,int color){
        if(r<0||r>=g.length||c<0||c>=g[0].length||g[r][c]!=old)return;
        g[r][c]=color;dfs(g,r+1,c,old,color);dfs(g,r-1,c,old,color);dfs(g,r,c+1,old,color);dfs(g,r,c-1,old,color);
    }
}
