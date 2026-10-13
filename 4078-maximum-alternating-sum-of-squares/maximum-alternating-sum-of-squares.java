class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) arr[i] = arr[i] * arr[i];
        Arrays.sort(arr);
        int i = 0 , j = n-1;
        long ans = arr[j--];
        while(i < j){
            ans -= arr[i++];
            ans += arr[j--];
        }
        if(i == j) ans -= arr[i];
        return ans;
    }
}