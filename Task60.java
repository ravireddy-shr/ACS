import java.util.*;
class Solution {
    public boolean canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> g=new ArrayList<>(); int[] in=new int[numCourses];
        for(int i=0;i<numCourses;i++)g.add(new ArrayList<>());
        for(int[] p:prerequisites){g.get(p[1]).add(p[0]);in[p[0]]++;}
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)if(in[i]==0)q.offer(i);
        int done=0;
        while(!q.isEmpty()){int u=q.poll();done++;for(int v:g.get(u))if(--in[v]==0)q.offer(v);}
        return done==numCourses;
    }
}
