class Solution {
    static int Target;
    public int findTargetSumWays(int[] arr, int target) {
        Target = target;
        return sum(arr , 0 , 0);
    }
    public int sum(int[] arr , int idx , int sum){
        if(idx >= arr.length){
            return (sum == Target) ? 1 : 0;
        }
        int a = sum(arr , idx+1 , sum+arr[idx]);
        int b = sum(arr , idx+1 , sum-arr[idx]);
        return a+b;
    }
}