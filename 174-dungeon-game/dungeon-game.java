class Solution {
    static int[][] dp;
    public static int calculateMinimumHP(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i] , -1);
        return fxn(arr , 0 , 0);
    }
    public static int fxn(int[][] arr , int i , int j) {
        if (i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE;
        if (i == arr.length-1 && j == arr[0].length-1) return arr[i][j] >= 0 ? 1 : Math.abs(arr[i][j])+1;
        if(dp[i][j] != -1) return dp[i][j];
        int r = fxn(arr , i , j+1);
        int d = fxn(arr , i+1 , j);
        int res = arr[i][j] - Math.min(r , d);
        return dp[i][j] = res >=0 ? 1 : Math.abs(res);
    }
}