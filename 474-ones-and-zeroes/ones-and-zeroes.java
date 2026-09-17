class Solution {
    static int[] ones;
    static int[][][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        ones = new int[strs.length];
        for (int i=0; i<strs.length; i++){
            int count = 0;
            for (int j=0; j<strs[i].length(); j++) if(strs[i].charAt(j) == '1') count++;
            ones[i] = count;
        }
        dp = new int[strs.length][m+1][n+1];
        for (int[][] ele : dp){
            for (int[] el : ele) Arrays.fill(el , -1);
        }
        return maxSubset(0 , m , n , strs);
    }

    public static int maxSubset(int idx, int m, int n, String[] strs) {
        if (idx == strs.length) return 0;
        if (dp[idx][m][n] != -1) return dp[idx][m][n];
        int len =strs[idx].length();
        int zero = len-ones[idx];
        int skip = maxSubset(idx+1 , m , n , strs);
        int pick = 0;
        if(zero <= m && ones[idx] <= n) pick = 1 + maxSubset(idx+1 , m-zero , n-ones[idx] , strs);
        return dp[idx][m][n] = Math.max(pick , skip);
    }
}