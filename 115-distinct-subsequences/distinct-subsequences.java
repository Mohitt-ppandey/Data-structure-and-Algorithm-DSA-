class Solution {
    static int[][] dp;
    public int numDistinct(String s, String t) {
        int idx = 0;
        // for(int i=0; i<s.length(); i++) {
        //     if(s.charAt(i) == t.charAt(0)){
        //         idx = i;
        //         break;
        //     } 
        // }
        dp = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++) Arrays.fill(dp[i] , -1);
        return ways(s , t , idx , 0);
    }
    public int ways(String s , String t , int i , int j){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int pick = 0 , skip = 0;
        if(s.charAt(i) == t.charAt(j)) {
            pick =  pick + ways(s , t , i+1 , j+1);
            skip = skip + ways(s , t , i+1 , j);
        }
        else skip = skip + ways(s , t , i+1 , j);
        return dp[i][j] = pick + skip;
    }
}