class Solution {
    static Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n+1];
        return isValid(0 , 0 , s);
    }
    public boolean isValid(int i , int count , String str){
        if(i == str.length()) return count == 0;
        if (count < 0) return false;
        if(dp[i][count] != null) return dp[i][count];
        if(str.charAt(i) == '(') return dp[i][count] = isValid(i+1 , count+1 , str);
        else if(str.charAt(i) == ')') return dp[i][count] = isValid(i+1 , count-1 , str);
        else{
            boolean a = isValid(i+1 , count+1 , str);
            boolean b = isValid(i+1 , count-1 , str);
            boolean c = isValid(i+1 , count , str);
            return dp[i][count] = a || b || c;
        }
    }
}