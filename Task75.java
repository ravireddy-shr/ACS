import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points,int k){
        quickSelect(points,0,points.length-1,k-1);
        return Arrays.copyOf(points,k);
    }
    private void quickSelect(int[][] a,int l,int r,int target){
        while(l<r){int p=partition(a,l,r);if(p==target)return;if(p<target)l=p+1;else r=p-1;}
    }
    private int partition(int[][] a,int l,int r){
        long pivot=dist(a[r]);int store=l;
        for(int i=l;i<r;i++)if(dist(a[i])<=pivot)swap(a,i,store++);
        swap(a,store,r);return store;
    }
    private long dist(int[] p){return (long)p[0]*p[0]+(long)p[1]*p[1];}
    private void swap(int[][] a,int i,int j){int[] t=a[i];a[i]=a[j];a[j]=t;}
}
