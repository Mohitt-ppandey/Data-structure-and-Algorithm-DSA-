class Solution {
    static int[][][] dp;
    public int minCost(int[][] arr) {
        int m = arr.length , n = arr[0].length;
        dp = new int[m][n][2024];
        for(int[][] ele : dp){
            for(int[] el : ele) Arrays.fill(el , -1);
        }
        return fxn(0 , 0 , 0 , arr);
    }
    public int fxn(int i , int j , int xor , int[][] arr){
        if(i >= arr.length || j >= arr[0].length) return 1<<20;
        if(i == arr.length-1 && j == arr[0].length-1) return arr[i][j]^xor;
        if(dp[i][j][xor] != -1) return dp[i][j][xor];
        int r = fxn(i , j+1 , arr[i][j]^xor , arr);
        int d = fxn(i+1 , j , arr[i][j]^xor , arr);
        return dp[i][j][xor] = Math.min(r , d);
    }
}