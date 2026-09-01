class Solution {
    public static int rob(int[] arr) {
        if (arr.length == 1) return arr[0];
        int[] dp1 = new int[arr.length];
        Arrays.fill(dp1 , -1);
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp2 , -1);;
        return Math.max(robb(arr , 0 , arr.length-1 , dp1) , robb(arr , 1 , arr.length , dp2));
    }

    public static int robb(int[] arr, int idx , int n , int[] dp) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int a = arr[idx] + robb(arr , idx+2 , n , dp);
        int b = robb(arr , idx+1 , n , dp);
        return dp[idx] = Math.max(a , b);
    }
}