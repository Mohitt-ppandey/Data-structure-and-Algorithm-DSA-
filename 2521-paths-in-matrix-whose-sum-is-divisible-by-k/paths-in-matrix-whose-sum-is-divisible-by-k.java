class Solution {
    static int[][][] dp;
    static int mod = (int) 1e9+7;
    public int numberOfPaths(int[][] arr, int k) {
        int m = arr.length , n = arr[0].length;
        dp = new int[m+1][n+1][k+1];
        for(int[][] ele : dp){
            for(int[] el : ele) Arrays.fill(el , -1);
        }
        return fxn(0 , 0 , arr , k  , 0);
    }
    public int fxn(int i , int j , int[][] arr , int k , int sum){
        if(i == arr.length-1 && j == arr[0].length-1) return ((sum+arr[i][j])%k == 0) ? 1 : 0;
        if(i >= arr.length || j >= arr[0].length) return 0;
        if(dp[i][j][sum] != -1) return dp[i][j][sum];
        int down = fxn(i+1 , j , arr , k , (sum+arr[i][j])%k);
        int right = fxn(i , j+1 , arr , k , (sum+arr[i][j])%k);
        return dp[i][j][sum] = (right + down)%mod;
    }
}