class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        int x = 10;
        while(n >= 0){
            if(n < x) return false;
            n -= x--;
            if(n < x) return true;
            n -= x--; 
        }
        return true;
    }
}