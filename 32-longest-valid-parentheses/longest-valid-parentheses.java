class Solution {
    public int longestValidParentheses(String s) {
        int open = 0 , close = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(open == close) ans = Math.max(ans , open+close);
            if(open < close) {
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0; 
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(open == close) ans = Math.max(ans , open+close);
            if(open > close) {
                open = 0;
                close = 0;
            }
        }
        return ans;
    }
}