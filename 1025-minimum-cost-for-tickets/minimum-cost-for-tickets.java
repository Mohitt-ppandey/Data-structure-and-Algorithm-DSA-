class Solution {
    static int[] arr;
    static int[] cost;
    static int[][] dp;
    public int mincostTickets(int[] days, int[] costs) {
        arr = days;
        cost = costs;
        dp = new int[arr.length][400];
        for(int[] el : dp) Arrays.fill(el , -1);
        return minCost(0 , 0);
    }
    public int minCost(int i , int count){
        if(i >= arr.length) return 0;
        if(dp[i][count] != -1) return dp[i][count];
        if(arr[i] <= count) return minCost(i+1 , count);
        int a = cost[0] + minCost(i+1 , arr[i]);
        int b = cost[1] + minCost(i+1 , arr[i]+6);
        int c = cost[2] + minCost(i+1 , arr[i]+29);
        return dp[i][count] = Math.min(a , Math.min(b , c));
    }
}