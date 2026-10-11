class Solution {
    public int maxValidPairSum(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int[] preMax = new int[n];
        preMax[0] = arr[0];
        for(int i=1; i<n; i++) preMax[i] = Math.max(preMax[i-1] , arr[i]);
        for(int i=k; i<n; i++){
            ans = Math.max(ans , arr[i]+preMax[i-k]);
        }
        return ans;
    }
}