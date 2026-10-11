class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        int maxLen = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(i,j,s)){
                    if((j-i+1) > maxLen) {
                        ans = s.substring(i, j+1);
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(int i , int j , String s){
        if(i > j) return true;
        if(s.charAt(i) == s.charAt(j)) return isPalindrome(i+1 , j-1 , s);
        return false;
    }
}