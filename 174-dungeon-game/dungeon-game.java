class Solution {
    public static int calculateMinimumHP(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = (arr[m-1][n-1] >=  0) ? 1 : Math.abs(arr[m-1][n-1])+1;
        for (int i=m-2; i>=0; i--) dp[i][n-1] = ((arr[i][n-1]-dp[i+1][n-1]) >=  0) ? 1 : dp[i+1][n-1] - arr[i][n-1];
        for (int j=n-2; j>=0; j--)dp[m-1][j] = ((arr[m-1][j]-dp[m-1][j+1]) >=  0) ? 1 : dp[m-1][j+1] - arr[m-1][j];
        for(int i=m-2; i>=0; i--){
            for (int j=n-2; j>=0; j--){
                int min = Math.min(dp[i+1][j] , dp[i][j+1]);
                dp[i][j] =  ((arr[i][j] - min) >= 0) ? 1 : min - arr[i][j];
            }
        }
        return dp[0][0];
    }
}