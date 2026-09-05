class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int n = arr.length;
        int[] Max = new int[n];
        int[] Min = new int[n];

        Max[0] = arr[0];
        for (int i = 1; i < n; i++) {
            Max[i] = Math.max(Max[i - 1], arr[i]);
        }

        Min[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            Min[i] = Math.min(Min[i + 1], arr[i]);
        }

        for(int i=0; i<n; i++){
            int diff = Max[i]-Min[i];
            if(diff <= k) return i;
        }
        return -1;
    }
}