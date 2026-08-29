class Solution {
    static int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp , -1);
        return Math.min(minCost(cost , 0) , minCost(cost , 1));
    }
    public static int minCost(int[] cost , int idx) {
        if (idx >= cost.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int a = cost[idx] + minCost(cost , idx+1);
        int b = cost[idx] + minCost(cost , idx+2);
        return dp[idx] = Math.min(a , b);
    }
}