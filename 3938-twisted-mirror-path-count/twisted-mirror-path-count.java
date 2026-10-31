class Solution {
    static int mod = (int) 1e9+7;
    static int[][][] dp;
    public int uniquePaths(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        dp = new int[m][n][3];
        for(int[][] ele : dp){
            for(int[] el : ele) Arrays.fill(el , -1);
        }
        return fxn(0 , 0 , -1 , arr);
    }
    public int fxn(int i , int j , int state , int[][] arr){
        if(i >= arr.length || j >= arr[0].length) return 0;
        if(i == arr.length-1 && j == arr[0].length-1) return 1;
        if(dp[i][j][state+1] != -1) return dp[i][j][state+1];
        if(arr[i][j] == 1) {
            return (state == 0) ? fxn(i+1 , j , 1 , arr) : fxn(i , j+1 , 0 , arr);
        }
        int right = fxn(i , j+1 , 0 , arr);
        int down = fxn(i+1 , j , 1 , arr); 
        return dp[i][j][state+1] = (right + down)%mod;
    }
}