class Solution {
    static int[][] dp;
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        dp = new int[100][100];
        for(int i=0; i<n; i++) Arrays.fill(dp[i] , Integer.MIN_VALUE);
        for(int j=0; j<arr[0].length; j++) ans = Math.min(ans , minPathSum(arr , 0 , j));
        return ans;
    }
    public int minPathSum(int[][] arr , int i , int j){
        if(j >= arr[0].length || j < 0) return Integer.MAX_VALUE;
        if(i == arr.length-1) return arr[i][j];
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int a = minPathSum(arr , i+1 , j-1);
        int b = minPathSum(arr , i+1 , j);
        int c = minPathSum(arr , i+1 , j+1);
        return dp[i][j] = arr[i][j] + Math.min(a , Math.min(b , c));
    }
}