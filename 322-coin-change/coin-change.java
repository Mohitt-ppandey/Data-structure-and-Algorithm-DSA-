class Solution {
    static int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        dp = new int[m][amount+1];
        for(int i=0; i<m; i++) Arrays.fill(dp[i] , -1);
        int ans = minCoins(coins , 0 , amount);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public int minCoins(int[] coins, int i , int amount){
        if(i >= coins.length) return (amount == 0) ? 0 : Integer.MAX_VALUE;
        if(dp[i][amount] != -1) return dp[i][amount];
        int skip = minCoins(coins , i+1 , amount);
        int pick = Integer.MAX_VALUE;
        if(amount >= coins[i]){
            pick = minCoins(coins , i , amount-coins[i]);
            if(pick != Integer.MAX_VALUE) pick++;
        } 
        return dp[i][amount] = Math.min(skip , pick);
    }
}