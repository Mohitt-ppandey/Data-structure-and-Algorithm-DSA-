class Solution {
    static int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        if(m==1) return 1;
        dp = new int[m][m];
        for(int i=0; i<m; i++) dp[i][i] = 1;
        int i=0 , j = 1; 
        while(j < m){
            int k = j;
            while(k < m){
                if(s.charAt(i) == s.charAt(k)) dp[i][k] = 2 + dp[i+1][k-1];
                else dp[i][k] = Math.max(dp[i+1][k] , dp[i][k-1]);
                i++;
                k++;
            }
            i = 0;
            j++;
        }
        return dp[0][m-1];
    }
}