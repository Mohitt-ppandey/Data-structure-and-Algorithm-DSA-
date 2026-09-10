class Solution {
    static int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        if(m==1) return 1;
        dp = new int[m][m];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        return LCS(s , 0 , m-1);
    }
    public int LCS(String a , int i , int j){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == j) return dp[i][j] = 1 + LCS(a , i+1 , j-1);
        else if(a.charAt(i) == a.charAt(j)) return dp[i][j] = 2 + LCS(a , i+1 , j-1);
        else return dp[i][j] = Math.max(LCS(a , i+1 , j) , LCS(a , i , j-1));
    }
}