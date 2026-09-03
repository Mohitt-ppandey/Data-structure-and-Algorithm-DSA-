class Solution {
    static int[][] dp;
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i] , -1);
        return ways(arr , m-1 , n-1);
    }
    public int ways(int[][] arr , int i , int j){
        if(i < 0 || j < 0) return 0;
        if((arr[i][j] != 1) && i == 0 && j == 0) return 1;
        if(arr[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = ways(arr , i-1 , j) + ways(arr , i , j-1);
    }
}