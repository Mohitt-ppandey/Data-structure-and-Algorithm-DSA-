class Solution {
    static int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return fxn(0 , amount , coins);
    }
    public int fxn(int idx , int amount, int[] coins) {
        if(idx == coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int skip = fxn(idx+1 , amount , coins);
        int pick = (amount >= coins[idx]) ? fxn(idx , amount-coins[idx] , coins) : 0;
        return dp[idx][amount] = pick + skip;
    }
}