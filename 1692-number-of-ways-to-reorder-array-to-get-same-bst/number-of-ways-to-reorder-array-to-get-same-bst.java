class Solution {
    static int mod = (int)1e9 + 7;
    static long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        return (int)((fxn(nums) - 1 + mod) % mod);
    }

    public long fxn(int[] arr) {
        int n = arr.length;
        if (n < 3) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[0]) left.add(arr[i]);
            else right.add(arr[i]);
        }

        long x = fxn(left.stream().mapToInt(Integer::intValue).toArray());
        long y = fxn(right.stream().mapToInt(Integer::intValue).toArray());
        long z = nCr(n - 1, left.size());
        return (((x * y) % mod) * z) % mod;
    }

    public long nCr(int n, int r) {
        if (r == 0 || r == n) return 1;
        if (dp[n][r] != -1) return dp[n][r];
        return dp[n][r] = (nCr(n - 1, r) + nCr(n - 1, r - 1)) % mod;
    }
}