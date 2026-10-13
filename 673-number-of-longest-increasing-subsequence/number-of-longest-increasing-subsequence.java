class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++) if(arr[j] < arr[i]) dp[i] = Math.max(dp[i] , dp[j]+1);
            max = Math.max(max , dp[i]);
        }
        //System.out.println(max);
        int[] count = new int[n];
        for(int i=0; i<n; i++){
            count[i] = 1;
            int x = 0;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(dp[j]+1 == dp[i]) x += count[j];
                }
            }
            count[i] = (x != 0) ? x : 1;
        }
        int ans = 0;
        for(int i=0; i<n; i++) if(dp[i] == max) ans += count[i];
        return ans;
    }
}