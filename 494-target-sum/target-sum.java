class Solution {
    static int Target;
    static HashMap<String , Integer> dp;
    public int findTargetSumWays(int[] arr, int target) {
        Target = target;
        dp = new HashMap<>();
        return sum(arr , 0 , 0);
    }
    public int sum(int[] arr , int idx , int sum){
        if(idx >= arr.length) return (sum == Target) ? 1 : 0;
        String key = sum + " , " + idx;
        if(dp.containsKey(key)) return dp.get(key);
        int a = sum(arr , idx+1 , sum+arr[idx]);
        int b = sum(arr , idx+1 , sum-arr[idx]);
        dp.put(key , a+b);
        return a+b;
    }
}