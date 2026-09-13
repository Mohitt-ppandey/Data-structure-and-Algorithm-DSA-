class Solution {
    static Boolean[][] dp; 
    public boolean canCross(int[] arr) {
        if((arr[1]-arr[0]) > 1) return false;
        dp = new Boolean[arr.length][arr.length];
        //for(int[] ele : arr) Arrays.fill(ele , -1);
        return isReach(arr , 1 , 1);
    }
    public boolean isReach(int[] arr , int idx , int unit){
        if(idx == arr.length-1) return true;
        if(unit <= 0) return false;
        if(dp[idx][unit] != null) return dp[idx][unit];
        boolean a = false , b = false , c = false;;
        for(int i=idx+1; i<arr.length; i++){
            if(arr[i] == (arr[idx]+unit-1)) a = isReach(arr , i , unit-1); 
            if(arr[i] == (arr[idx]+unit)) b = isReach(arr , i , unit); 
            if(arr[i] == (arr[idx]+unit+1)) c = isReach(arr , i , unit+1);
        }
        return dp[idx][unit] = a || b || c;
    }
}