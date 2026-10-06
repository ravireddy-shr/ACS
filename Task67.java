import java.util.*;
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n=accounts.size();int[] p=new int[n],rank=new int[n];for(int i=0;i<n;i++)p[i]=i;
        Map<String,Integer> owner=new HashMap<>();
        for(int i=0;i<n;i++)for(int j=1;j<accounts.get(i).size();j++){
            String e=accounts.get(i).get(j);
            if(owner.containsKey(e))union(p,rank,i,owner.get(e));else owner.put(e,i);
        }
        Map<Integer,List<String>> map=new HashMap<>();
        for(String e:owner.keySet()){int r=find(p,owner.get(e));map.computeIfAbsent(r,k->new ArrayList<>()).add(e);}
        List<List<String>> ans=new ArrayList<>();
        for(var e:map.entrySet()){Collections.sort(e.getValue());List<String> a=new ArrayList<>();a.add(accounts.get(e.getKey()).get(0));a.addAll(e.getValue());ans.add(a);}
        return ans;
    }
    private int find(int[] p,int x){return p[x]==x?x:(p[x]=find(p,p[x]));}
    private void union(int[] p,int[] r,int a,int b){a=find(p,a);b=find(p,b);if(a==b)return;if(r[a]<r[b])p[a]=b;else{p[b]=a;if(r[a]==r[b])r[a]++;}}
}
