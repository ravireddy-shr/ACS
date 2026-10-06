import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat){
        int m=mat.length,n=mat[0].length;int[][] d=new int[m][n];Queue<int[]> q=new ArrayDeque<>();
        for(int r=0;r<m;r++){Arrays.fill(d[r],-1);for(int c=0;c<n;c++)if(mat[r][c]==0){d[r][c]=0;q.offer(new int[]{r,c});}}
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){int[] a=q.poll();for(int[] x:dirs){int r=a[0]+x[0],c=a[1]+x[1];if(r>=0&&r<m&&c>=0&&c<n&&d[r][c]==-1){d[r][c]=d[a[0]][a[1]]+1;q.offer(new int[]{r,c});}}}
        return d;
    }
}
