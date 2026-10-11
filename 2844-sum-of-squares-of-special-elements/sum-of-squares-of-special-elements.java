class Solution {
    public int sumOfSquares(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(n%(i+1) == 0) ans += (arr[i]*arr[i]);
        }
        return ans;
    }
}