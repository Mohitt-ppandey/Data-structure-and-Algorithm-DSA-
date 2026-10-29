class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int buy = arr[0] , sell = 0;
        for(int i=1; i<n; i++){
            if(arr[i] < buy){
                buy = arr[i];
                sell = arr[i];
            }else sell = Math.max(sell , arr[i]);
            ans = Math.max(ans , (sell-buy));
        }
        return ans;
    }
}