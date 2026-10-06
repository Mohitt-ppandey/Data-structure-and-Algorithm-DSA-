class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0 , close = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(close > open) {
                count += (close-open);
                close = open;
            }    
        }
        count += open-close;
        return count;
    }
}