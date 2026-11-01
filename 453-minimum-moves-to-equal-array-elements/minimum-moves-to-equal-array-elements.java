class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for(int i=1; i<n; i++){
            count += (arr[i]-arr[0]);
        }
        return count;
    }
}