class Solution {
    static int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[1] = n;
        for(int i=2; i<m+2; i++) arr[i] = cuts[i-2];
        Arrays.sort(arr);
        dp = new int[m+2][m+2];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return cost(1 , m , arr);
    }
    public int cost(int i , int j , int[] arr){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int len =  (arr[j+1] - arr[i-1]);
            int tc = cost(i , k-1 , arr) + cost(k+1 , j , arr) + len;
            min = Math.min(min , tc);
        }
        return dp[i][j] = min;
    }
}