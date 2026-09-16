class Solution {
    static int[] dp;
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return count(s , 0);
    }
    public static int count(String str , int idx){
        if (idx >= str.length()) return 1;
        if (str.charAt(idx) == '0') return 0;
        if (dp[idx] != -1) return dp[idx];
        int a = count(str , idx+1);
        int b = 0;
        if(idx+2 <= str.length() && Integer.parseInt(str.substring(idx, idx+2)) <= 26) b = count(str , idx+2);
        return dp[idx] = a+b;
    }
}
