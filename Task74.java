import java.util.*;
class Solution {
    private int[] nums,idx,tmpIdx,count;
    public List<Integer> countSmaller(int[] nums){
        int n=nums.length;this.nums=nums;idx=new int[n];tmpIdx=new int[n];count=new int[n];
        for(int i=0;i<n;i++)idx[i]=i;
        sort(0,n-1);
        List<Integer> ans=new ArrayList<>();for(int x:count)ans.add(x);return ans;
    }
    private void sort(int l,int r){
        if(l>=r)return;int m=l+(r-l)/2;sort(l,m);sort(m+1,r);merge(l,m,r);
    }
    private void merge(int l,int m,int r){
        int i=l,j=m+1,k=l,smaller=0;
        while(i<=m&&j<=r){
            if(nums[idx[j]]<nums[idx[i]]){tmpIdx[k++]=idx[j++];smaller++;}
            else{count[idx[i]]+=smaller;tmpIdx[k++]=idx[i++];}
        }
        while(i<=m){count[idx[i]]+=smaller;tmpIdx[k++]=idx[i++];}
        while(j<=r)tmpIdx[k++]=idx[j++];
        for(int p=l;p<=r;p++)idx[p]=tmpIdx[p];
    }
}
