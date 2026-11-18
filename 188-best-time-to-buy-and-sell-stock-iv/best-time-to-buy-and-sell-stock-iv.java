class Solution {
    static int[][][] dp;
    public int maxProfit(int k, int[] arr) {
        int n  = arr.length;
        dp = new int[n][2][k+1];
        for(int[][] ele : dp){
            for(int[] el : ele) Arrays.fill(el , -1);
        }
        return maxAchieve(0 , 0 , k , arr);
    }
    public int maxAchieve(int i , int buy , int limit , int[] arr){
        if(i >= arr.length || limit == 0) return 0;
        if(dp[i][buy][limit] != -1) return dp[i][buy][limit];
        if(buy == 0) {
            int buyOp = -arr[i] + maxAchieve(i+1 , 1 , limit , arr);
            int skip = maxAchieve(i+1 , buy , limit , arr);
            return dp[i][buy][limit] = Math.max(buyOp , skip);
        }else {
            int sell = arr[i] + maxAchieve(i+1 , 0 , limit-1 , arr);
            int skip = maxAchieve(i+1 , buy , limit , arr);
            return dp[i][buy][limit] = Math.max(sell , skip);
        }
    }
}