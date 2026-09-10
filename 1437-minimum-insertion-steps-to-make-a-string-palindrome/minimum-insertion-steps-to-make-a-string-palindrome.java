class Solution {
    static int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] arr : dp) Arrays.fill(arr , -1);
        return n-lcp(s , 0 , n-1);
    }
    public int lcp(String s , int i , int j){
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        else if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + lcp(s , i+1 , j-1);
        else return  dp[i][j] = Math.max(lcp(s , i+1 , j) , lcp(s , i , j-1));
    }
}