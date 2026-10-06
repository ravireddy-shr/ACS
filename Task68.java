import java.util.*;
class Solution {
    public boolean isHappy(int n){
        Set<Integer> seen=new HashSet<>();
        while(n!=1&&!seen.contains(n)){seen.add(n);n=sum(n);}
        return n==1;
    }
    private int sum(int n){int s=0;while(n>0){int d=n%10;s+=d*d;n/=10;}return s;}
}
