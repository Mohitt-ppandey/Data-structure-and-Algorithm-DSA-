class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        for(int i=0; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++) if(arr[j] < arr[i]) lis[i] = Math.max(lis[i] , lis[j]+1);
        }

        int[] lds = new int[n];
        for(int i=n-1; i>=0; i--){
            lds[i] = 1;
            for(int j=i; j<n; j++) if(arr[j] < arr[i]) lds[i] = Math.max(lds[i] , lds[j]+1);
        }
        int maxLen = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            if(lis[i] > 1 && lds[i] > 1) max = lis[i] + lds[i] - 1;
            maxLen = Math.max(max , maxLen);
        }
        return n-maxLen;
    }
}