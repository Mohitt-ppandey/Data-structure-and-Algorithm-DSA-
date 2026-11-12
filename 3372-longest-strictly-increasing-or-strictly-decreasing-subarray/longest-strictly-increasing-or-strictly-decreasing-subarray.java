class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int i = 0 , j = 1;
        while(j<n){
           if(arr[j] > arr[j-1]) ans = Math.max(ans , j-i+1);
            else if(arr[j] <= arr[j-1]) i = j;
            j++;
        }
        i = n-1;
        j=n-2; 
        while(j>=0){
           if(arr[j] > arr[j+1]) ans = Math.max(ans , i-j+1);
            else if(arr[j] <= arr[j+1]) i = j;
            j--;
        }
        return (ans != 0) ? ans : 1;
    }
}