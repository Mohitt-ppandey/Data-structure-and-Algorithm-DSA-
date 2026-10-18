class Solution {
    static int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        for(int i=1; i<=n; i++) arr[i] = nums[i-1];
        arr[n+1] = 1;
        dp = new int[n+1][n+1];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return maxCoins(1 , n , arr);
    }
    public int maxCoins(int i , int j ,int[] arr){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int len = arr[i-1] * arr[k] * arr[j+1];
            int cost = maxCoins(i , k-1 , arr) + maxCoins(k+1 , j , arr) + len;
            max = Math.max(max , cost);
        }
        return dp[i][j] = max;
    }
}