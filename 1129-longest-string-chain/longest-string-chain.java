class Solution {
    static int[][] dp;
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        dp = new int[words.length][words.length+1];
        for(int[] ele : dp) Arrays.fill(ele , -1);
        return longestChain(0 , -1 , words);
    }
    public int longestChain(int i, int prev, String[] str) {
    if(i >= str.length) return 0;
    int pick = 0, skip = 0;
    if(dp[i][prev+1] != -1) return dp[i][prev+1];
    if(prev == -1 || possible(0, 0, str[prev], str[i])) {
        pick = 1 + longestChain(i+1, i, str);
    }
    skip = longestChain(i+1, prev, str);
    return dp[i][prev+1] = Math.max(pick, skip);
}
    public boolean possible(int i, int j, String s1, String s2) {
    if(s2.length() - s1.length() != 1) return false;
    while(i < s1.length() && j < s2.length()) {
        if(s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else j++;
    }
    return i == s1.length();
}
}