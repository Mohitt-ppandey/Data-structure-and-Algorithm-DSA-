class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int total = m+n-2;
        int way = m-1;
        if(way > (total-way)) way = total-way;
        for(int i=0; i<way; i++){
            ans *= (total - i);
            ans /= (i+1); 
        }
        return (int)ans;
    }
}