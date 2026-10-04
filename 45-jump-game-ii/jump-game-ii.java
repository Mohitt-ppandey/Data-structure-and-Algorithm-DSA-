class Solution {
    static int[] dp;
    public int jump(int[] arr) {
        dp = new int[arr.length];
        Arrays.fill(dp , -1);
        return minJump(0 , arr);
    }
    public int minJump(int i , int[] arr){
        if(i == arr.length-1) return 0;
        if(i >= arr.length) return Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];
        int ans =  Integer.MAX_VALUE, a = 0;
        for(int j=1; j<=arr[i]; j++){
            int pick = minJump(i+j , arr);
            a = (pick == Integer.MAX_VALUE) ? pick : 1 + pick;
            ans = Math.min(ans , a);
        }
        return dp[i] = ans;
    }
}