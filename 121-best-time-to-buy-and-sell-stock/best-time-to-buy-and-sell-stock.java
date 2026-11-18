class Solution {
    static int[][][] dp;
    public int maxProfit(int[] arr) {
        int n = arr.length;
        dp = new int[n][2][2];
        for(int[][] ele : dp){
            for(int[] el : ele) Arrays.fill(el , -1);
        }
        return profit(0 , 0 , 1 , arr);
    }
    public int profit(int i , int buy , int limit , int[] arr){
        if(i >= arr.length || limit == 0) return 0;
        if(dp[i][buy][limit] != -1) return dp[i][buy][limit];
        if(buy == 1){
            int sell = arr[i] + profit(i+1 , 0 , limit-1 , arr);
            int skip = profit(i+1 , buy , limit , arr);
            return dp[i][buy][limit] = Math.max(sell , skip);
        }else{
            int buyop = -arr[i] + profit(i+1 , 1 , limit , arr);
            int skip = profit(i+1 , buy , limit , arr);
            return dp[i][buy][limit] = Math.max(buyop , skip);
        }
        //return 0;
    }
}