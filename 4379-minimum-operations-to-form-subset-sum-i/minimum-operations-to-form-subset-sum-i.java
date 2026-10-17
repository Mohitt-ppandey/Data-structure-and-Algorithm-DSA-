class Solution {
    public int minOperations(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int[] ele : dp) Arrays.fill(ele , (int)1e4);
        for(int i=0; i<=n; i++) dp[i][0] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                int skip = dp[i-1][j];
                int cost = 0;
                for(int k=arr[i-1]; k<=j; k *= 2){
                    int pick = cost + dp[i-1][j-k];
                    dp[i][j] = Math.min(dp[i][j] , Math.min(pick , skip));
                    cost++;
                }
                cost = 0;
                for(int k=arr[i-1]; k>=1; k /= 2){
                    if(k <= j){
                        int pick = cost + dp[i-1][j-k];
                        dp[i][j] = Math.min(dp[i][j] , Math.min(pick , skip));
                    }
                    cost++;
                }
            }
        }
        if(dp[n][sum] > 5000) return -1;
        return dp[n][sum];
    }
}