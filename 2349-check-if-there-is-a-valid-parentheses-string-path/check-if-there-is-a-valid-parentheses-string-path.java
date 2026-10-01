class Solution {
    static Boolean[][][] dp;
    public boolean hasValidPath(char[][] arr) {
        int m = arr.length , n = arr[0].length;
        if(arr[0][0] == ')' || arr[m-1][n-1] == '(') return false;
        dp = new Boolean[m+1][n+1][m+n];
        return isValid(0 , 0 , 0 , arr);
    }
    public boolean isValid(int i , int j , int count , char[][] arr){
        if(i == arr.length-1 && j == arr[0].length-1) {
            if(arr[i][j] == '(') count+=1;
            else count -= 1;
            return count == 0;
        }
        if(count < 0) return false;
        if(i >= arr.length  || j >= arr[0].length) return false;
        if(dp[i][j][count] != null) return dp[i][j][count];
        boolean right = false , down = false;
        if(arr[i][j] == '('){
            right = isValid(i , j+1 , count+1 , arr);
            down = isValid(i+1 , j , count+1 , arr);
        }else{
            right = isValid(i , j+1 , count-1 , arr);
            down = isValid(i+1 , j , count-1 , arr);
        }
        return dp[i][j][count] = right || down;
    }
}