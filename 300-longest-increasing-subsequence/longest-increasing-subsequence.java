class Solution {
    static int[][] dp;
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        dp = new int[n][n+1];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return fxn(0 , -1 , arr);
    }
    public int fxn(int i , int preIdx , int[] arr){
        if(i >= arr.length) return 0;
        if(dp[i][preIdx+1] != -1) return dp[i][preIdx+1];
        int pick = 0;
        if(preIdx == -1 || arr[i] > arr[preIdx]) pick = 1 + fxn(i+1 , i , arr);
        int skip = fxn(i+1 , preIdx , arr);
        return dp[i][preIdx+1] = Math.max(pick , skip);
    }
}