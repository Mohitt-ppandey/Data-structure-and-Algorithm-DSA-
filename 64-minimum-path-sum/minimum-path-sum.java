class Solution {
    static int[][] dp;
    public int minPathSum(int[][] arr) {
        int n = arr.length , m = arr[0].length;
        dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i] , -1);
        return minSum(arr , 0 , 0);
    }
    public int minSum(int[][] arr , int i , int j){
        if(i == arr.length-1 && j == arr[0].length-1) return arr[i][j];
        if(i == arr.length-1) return arr[i][j] + minSum(arr , i , j+1);
        if(j == arr[0].length-1) return arr[i][j] + minSum(arr , i+1 , j);
        if(dp[i][j] != -1) return dp[i][j];
        int a = arr[i][j] + minSum(arr , i+1 , j);
        int b = arr[i][j] + minSum(arr , i , j+1);
        return dp[i][j] = Math.min(a , b);
    }
}