class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n-1 > trust.length) return -1;
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        for(int[] ele : trust){
            out[ele[0]]++;
            in[ele[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(in[i] == n-1 && out[i] == 0) return i; 
        }
        return -1;
    }
}