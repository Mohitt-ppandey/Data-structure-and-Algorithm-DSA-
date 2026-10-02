class Solution {
    static int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length+1];
        Arrays.fill(dp , -1);
        return sum(0 , arr , k);
    }
    public int sum(int idx , int[] arr , int k){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = 0 ,  max = 0;
        for(int i=0; i<k && i+idx < arr.length; i++){
            max = Math.max(max , arr[i+idx]);
            int take =(i+1)*max + sum(idx+i+1 , arr , k);
            pick = Math.max(pick , take);
        }
        return dp[idx] = pick;
    }
}