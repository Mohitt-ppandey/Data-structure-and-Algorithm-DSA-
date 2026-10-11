class Solution {
    static Boolean[][] dp;
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
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
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = isPalindrome(i+1 , j-1 , s);
        return dp[i][j] = false;
    }
}