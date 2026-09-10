class Solution {
    static int[][] dp;
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int m = s.length();
        dp = new int[m][m];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        return LCS(s , rev , m-1 , m-1);
    }
    public int LCS(String a, String b , int i , int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + LCS(a , b , i-1 , j-1);
        else return dp[i][j] = Math.max(LCS(a , b , i-1 , j) , LCS(a , b , i , j-1));
    }
}