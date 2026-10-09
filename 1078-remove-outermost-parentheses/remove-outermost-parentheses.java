class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0 , close = 0;
        int k = 0;
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(open == close){
                for(int j=k+1; j<i; j++){
                    str.append(s.charAt(j));
                }
                k = i+1;
                open = 0;
                close = 0;
            }
        } 
        return str.toString();
    }
}