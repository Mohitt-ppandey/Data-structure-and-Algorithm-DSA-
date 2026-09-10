class Solution {
    static int[][] dp;
    public int longestCommonSubsequence(String a, String b) {
        dp = new int[a.length()][b.length()];
        for(int[] ele : dp) Arrays.fill(ele,-1);
        return  LCS(a , b , a.length()-1 , b.length()-1);
    }
    public int LCS(String a, String b , int m , int n){
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(a.charAt(m) == b.charAt(n)) return dp[m][n] = 1 + LCS(a , b , m-1 , n-1);
        else{
            int x = LCS(a , b , m-1 , n);
            int y = LCS(a , b , m , n-1);
            return dp[m][n] = Math.max(x , y);
        }
    }
}