import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length,fresh=0,minutes=0;
        Queue<int[]> q=new ArrayDeque<>();
        for(int r=0;r<m;r++) for(int c=0;c<n;c++){
            if(grid[r][c]==2) q.offer(new int[]{r,c});
            else if(grid[r][c]==1) fresh++;
        }
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] x:d){
                    int nr=cur[0]+x[0],nc=cur[1]+x[1];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                        grid[nr][nc]=2; fresh--; q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
