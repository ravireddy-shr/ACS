import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i=0;i<n;i++) g.add(new ArrayList<>());
        for (int[] e: edges) { g.get(e[0]).add(e[1]); g.get(e[1]).add(e[0]); }
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source); seen[source]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            if(u==destination) return true;
            for(int v:g.get(u)) if(!seen[v]) { seen[v]=true; q.offer(v); }
        }
        return false;
    }
}
