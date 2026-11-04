class Solution {
    public int minMoves2(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        int mid = arr[n/2];
        for(int i=0; i<n; i++) count += Math.abs(mid - arr[i]);
        return count;
    }
}