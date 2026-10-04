class Solution {
    static int[] arr;
    static int[] cost;
    static int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        arr = days;
        cost = costs;
        dp = new int[365];
        Arrays.fill(dp , -1);
        return minCost(0);
    }
    public int minCost(int i){
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int j = i;
        while(j<arr.length && arr[j] < arr[i]+1) j++;
        int a = cost[0] + minCost(j);
        j = i;
        while(j<arr.length && arr[j] < arr[i]+7) j++;
        int b = cost[1] + minCost(j);
        j = i;
        while(j<arr.length && arr[j] < arr[i]+30) j++;
        int c = cost[2] + minCost(j);
        return dp[i] = Math.min(a , Math.min(b , c));
    }
}