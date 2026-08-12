class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) str += Character.toLowerCase(ch);
        }
        System.out.println(str);
        return check(str , 0);
    }
    public boolean check(String str , int n){
        if(n>=str.length()/2) return true;
        char ch = str.charAt(n);
        if(str.charAt(str.length()-1-n) != ch) return false;
        return check(str , n+1);
    }
}