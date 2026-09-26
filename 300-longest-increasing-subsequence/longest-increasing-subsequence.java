class Solution {
    static int[] dp;
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--) if(arr[i] > arr[j]) max = Math.max(max , dp[j]);
            dp[i] = 1 + max;
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}