class Solution {
    static int[][] dp;
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for(int ele : arr) totalSum += ele;
        int sum = totalSum/2;
        dp = new int[n][sum+1];
        if(arr[0] <= sum) for(int j=arr[0]; j<=sum; j++) dp[0][j] = arr[0];
        for(int i=1; i<n; i++){
            for(int j=1; j<=sum; j++){
                int skip = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(arr[i] <= j) pick =arr[i] + dp[i-1][j-arr[i]];
                dp[i][j] = Math.max(skip , pick);
            }
        }
        return  Math.abs(totalSum - 2 * dp[n-1][sum]);
    }
}