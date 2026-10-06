import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),ans);return ans;
    }
    private void backtrack(int[] nums,int start,List<Integer> cur,List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for(int i=start;i<nums.length;i++){cur.add(nums[i]);backtrack(nums,i+1,cur,ans);cur.remove(cur.size()-1);}
    }
}
