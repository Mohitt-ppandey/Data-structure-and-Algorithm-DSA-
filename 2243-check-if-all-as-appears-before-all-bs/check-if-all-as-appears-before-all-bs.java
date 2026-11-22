class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean ans = true;
        if(s.charAt(0) == 'b') ans = false;
        for(int i=1 ; i<n; i++){
            char ch = s.charAt(i);
            if(!ans && ch == 'a') return false;
            if(ans && ch == 'b') ans = false;
        }
        return true;
    }
}