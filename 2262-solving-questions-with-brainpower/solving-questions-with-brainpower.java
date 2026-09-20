class Solution {
    static long[] dp;
    public long mostPoints(int[][] questions) {
        int m = questions.length , n = questions[0].length; 
        dp = new long[m];
        Arrays.fill(dp , -1);
        return maxPoints(0 , questions);
    }
    public long maxPoints(int idx , int[][] arr){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        long skip = maxPoints(idx+1 , arr);
        long pick = arr[idx][0] + maxPoints(idx+arr[idx][1]+1 , arr);
        return dp[idx] = Math.max(skip , pick);
    }
}