class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i=1; i<strs.length; i++) {
           ans =  commonPrefix(ans , strs[i]);
        }
        return ans;    
    }
    public String commonPrefix(String s1 , String s2){
        String ans = "";
        for(int i=0; i<Math.min(s1.length(),s2.length()); i++) {
            if(s1.charAt(i) == s2.charAt(i)) ans += s1.charAt(i);
            else break;
        }
        return ans;
    }
}