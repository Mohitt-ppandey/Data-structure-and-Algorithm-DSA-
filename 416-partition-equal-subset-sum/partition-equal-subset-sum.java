class Solution {
    static Boolean[][] dp;
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int ele : arr) sum += ele;
        if(sum%2 != 0) return false;
        dp = new Boolean[arr.length][sum];
        return equall(arr , 0 , sum/2);
    }
    public boolean equall(int[] arr , int idx , int tsum){
        if(idx == arr.length) {
            if(tsum == 0) return true;
            else return false;
        } 
        if(dp[idx][tsum] != null) return dp[idx][tsum];
        boolean pick = false;
        if(tsum >= arr[idx]) pick = equall(arr , idx+1 , tsum-arr[idx]);
        boolean skip = equall(arr , idx+1 , tsum);
        return dp[idx][tsum] = pick || skip;
    }
}