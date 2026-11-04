class Solution {
    public int minMoves(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int ele = arr[n-1]; 
        int count = 0;
        for (int i = 0; i < n; i++) count += Math.abs(arr[i] - ele);
        return count;
    }
}