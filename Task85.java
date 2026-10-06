import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),ans);return ans;
    }
    private void backtrack(int start,int n,int k,List<Integer> cur,List<List<Integer>> ans){
        if(cur.size()==k){ans.add(new ArrayList<>(cur));return;}
        for(int i=start;i<=n-(k-cur.size())+1;i++){cur.add(i);backtrack(i+1,n,k,cur,ans);cur.remove(cur.size()-1);}
    }
}
