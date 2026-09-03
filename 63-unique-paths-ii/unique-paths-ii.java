class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        int[][] dp = new int[m][n];
        if(arr[0][0] == 1) return 0;
        for(int i=0; i<m; i++) {
            if(arr[i][0] == 0) dp[i][0] = 1;
            else {
                break;
            }
        }
        for(int j=0; j<n; j++) {
            if(arr[0][j] == 0) dp[0][j] = 1;
            else {
                break;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(arr[i][j] != 1) dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}