class Solution {
    static int mod = (int) 1e9+7;
    static int[][] dp;
    public int numberOfSets(int n, int k) {
        if((n-k) <=1) return 1;
        if(k == 1) return (n*(n-1)/2);
        dp = new int[n][k+1];
        for(int[] el : dp) Arrays.fill(el , -1);
        return fxn(0 , k , n);
    }
    public int fxn(int idx , int k , int n){
        if(k == 0) return 1;
        if(idx >= n) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];
        int skip = fxn(idx+1 , k , n);
        int pick = 0;
        for(int i=idx+1; i<n; i++) pick = (pick + fxn(i , k-1 , n))%mod;
        return dp[idx][k] = (pick + skip)%mod;
    }
}