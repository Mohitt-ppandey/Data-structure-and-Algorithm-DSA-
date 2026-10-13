class Solution {
    static int[] dp;
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) if(arr[i] > arr[j]) dp[i] = Math.max(dp[i] , dp[j]+1);
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}