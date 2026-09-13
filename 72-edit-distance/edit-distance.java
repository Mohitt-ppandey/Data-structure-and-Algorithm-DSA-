class Solution {
    static int[][] dp;
    public int minDistance(String w1, String w2) {
        int m = w1.length() , n = w2.length();
        dp = new int[m][n];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return operations(m-1 , n-1 , new StringBuilder(w1) , new StringBuilder(w2));
    }
    public int operations(int i , int j , StringBuilder w1 , StringBuilder w2) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j)) return operations(i-1 , j-1 , w1 , w2);
        int insert = 1 +  operations(i , j-1 , w1 , w2);
        int delete = 1 +  operations(i-1 , j , w1 , w2);
        int replace = 1 + operations(i-1 , j-1 , w1 , w2);
        return dp[i][j] = Math.min(insert , Math.min(delete , replace)) ;
    }
}