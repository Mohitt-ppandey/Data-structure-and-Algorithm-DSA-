class Solution {
    static Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        dp = new Boolean[n+2][m+2];
        return REM(0 , 0 , s , p);
    }
    public boolean REM(int i , int j , String s , String p){
        if(j == p.length()) return i == s.length();
        if(dp[i][j] != null) return dp[i][j];
        boolean flag = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean skip = REM(i , j+2 , s , p);
            boolean pick = false;
            if(flag) pick = REM(i+1 , j , s , p);  
            return dp[i][j] =  pick || skip; 
        }
        if(flag) return dp[i][j] = REM(i+1 , j+1 , s , p);
        return dp[i][j] = false;
    }
}