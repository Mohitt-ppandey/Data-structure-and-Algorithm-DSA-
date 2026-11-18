class Solution {
    static int[][] dp;
    public int maxProfit(int[] arr) {
        int n = arr.length;
        dp = new int[n][2];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return maxAchieve(0 , 0 , arr);
    }
    public int maxAchieve(int i , int buy , int[] arr){
        if(i >= arr.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 0) {
            int buyOp = -arr[i] + maxAchieve(i+1 , 1 , arr);
            int skip = maxAchieve(i+1 , buy , arr);
            return dp[i][buy] = Math.max(buyOp , skip);
        }else {
            int sell = arr[i] + maxAchieve(i+1 , 0 , arr);
            int skip = maxAchieve(i+1 , buy , arr);
            return dp[i][buy] = Math.max(sell , skip);
        }
    }
}