import java.util.*;
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen=new boolean[rooms.size()];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0); seen[0]=true; int count=1;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:rooms.get(u)) if(!seen[v]){seen[v]=true;count++;q.offer(v);}
        }
        return count==rooms.size();
    }
}
