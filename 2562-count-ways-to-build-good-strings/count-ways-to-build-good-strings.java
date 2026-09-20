class Solution {
    static int mod = (int)1e9+7;
    static int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high+1];
        Arrays.fill(dp , -1);
        return fxn(0 , zero , one , low , high);
    }
    public int fxn(int len , int zero, int one, int low, int high){
        if(len > high) return 0;
        if(dp[len] != -1) return dp[len];
        int countZero = 0 , countOne = 0; 
        int take = fxn(len+zero , zero , one , low , high);
        if(len+zero >= low && len+zero <= high) countZero = (1 + take)%mod;
        else countZero = take;
        int pick = fxn(len+one , zero , one , low , high);
        if(len+one >= low && len+one <= high) countOne = (1 + pick)%mod;
        else countOne = pick;
        return dp[len] = (countZero + countOne)%mod;
    }
}