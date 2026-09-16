class Solution {
    static int totalSum;
    static int[][] dp;
    public int lastStoneWeightII(int[] arr) {
        totalSum = 0;
        for(int ele : arr) totalSum += ele;
        dp = new int[arr.length][totalSum];
        for(int[] ele : dp) Arrays.fill(ele , -1); 
        int a = fxn(arr , 0 , 0);
        return Math.abs(2*a - totalSum);
    }
    public int fxn(int[] arr , int idx , int sum){
        if(idx == arr.length) return 0;
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int skip = fxn(arr , idx+1 , sum);
        int pick = Integer.MIN_VALUE;
        if(sum+arr[idx] <= totalSum/2)  pick = arr[idx] + fxn(arr , idx+1 , sum+arr[idx]);
        return dp[idx][sum] = Math.max(pick , skip);
    }
}