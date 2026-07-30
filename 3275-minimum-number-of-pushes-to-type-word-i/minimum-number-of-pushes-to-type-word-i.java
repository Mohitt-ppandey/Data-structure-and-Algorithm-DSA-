class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        int x = n/8;
        int left = n%8;
        for(int i=1; i<=x; i++) ans += (8*i);
        return ans + left*(x+1);
        
    }
}