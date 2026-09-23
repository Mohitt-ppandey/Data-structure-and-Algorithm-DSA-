class Solution {
    static int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int m =  s1.length() , n  = s2.length();
        dp = new int[m+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr , -1);
        return fxn(m-1 , n-1 , s1 , s2);
    }
    public int fxn(int i , int j , String s1 , String s2){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + fxn(i-1 , j-1 , s1 , s2);
        else {
            return dp[i][j] = Math.max(fxn(i-1 , j, s1 , s2) , fxn(i , j-1 , s1 , s2));
        }
    }
}