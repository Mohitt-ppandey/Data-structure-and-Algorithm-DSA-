class Solution {
    static int mod = (int)1e9+7;
    static long[][][] dp;
    public int knightDialer(int n) {
        char[][] arr = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
        dp = new long[4][3][n+1];
        for(long[][] el : dp){
            for(long[] ele : el) Arrays.fill(ele , -1);
        }

        long count = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(arr[i][j] != '*' || arr[i][j] != '#') count = (count + isValid(i , j , arr , n))%mod;
            }
        }
        return (int)count;
    }
    public long isValid(int i , int j , char[][] arr , int n){
        if(i<0 || j < 0 || i >= 4 || j >= 3) return 0;
        if(arr[i][j] == '*' || arr[i][j] == '#') return 0;
        if(n == 1) return 1;
        if(dp[i][j][n] != -1) return dp[i][j][n];
        long a = isValid(i-2, j+1, arr, n - 1);
        long b = isValid(i-2, j-1, arr, n - 1);
        long c = isValid(i+2, j+1, arr, n - 1);
        long d = isValid(i+2, j-1, arr, n - 1);
        long e = isValid(i-1, j+2, arr, n - 1);
        long f = isValid(i-1, j-2, arr, n - 1);
        long g = isValid(i+1, j+2, arr, n - 1);
        long h = isValid(i+1, j-2, arr, n - 1);;
        return dp[i][j][n] = (a + b + c + d + e + f + g + h)%mod;
    }
}