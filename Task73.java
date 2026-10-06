class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()<2)return "";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(s.indexOf(Character.toLowerCase(ch))<0||s.indexOf(Character.toUpperCase(ch))<0){
                String a=longestNiceSubstring(s.substring(0,i));
                String b=longestNiceSubstring(s.substring(i+1));
                return a.length()>=b.length()?a:b;
            }
        }
        return s;
    }
}
