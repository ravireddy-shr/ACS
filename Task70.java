import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){int[] c=new int[26];for(char ch:s.toCharArray())c[ch-'a']++;StringBuilder k=new StringBuilder();for(int x:c)k.append('#').append(x);map.computeIfAbsent(k.toString(),x->new ArrayList<>()).add(s);}
        return new ArrayList<>(map.values());
    }
}
