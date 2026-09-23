class Solution {
    public int minOperations(int[] arr, int x) {
        int n = arr.length;
        int sum = 0;
        for(int ele : arr) sum += ele;
        int rem = sum - x;
        if(rem < 0) return -1;
        if(rem == 0) return n;
        int len = fxn(0 , 0 , arr , rem);
        if(len == -1) return len;
        return n - len;
    }
    public int fxn(int i , int j , int[] arr , int sum){
        int len = -1;
        int a = 0;
        while(j < arr.length){
            a += arr[j];
            if(a == sum) len = Math.max(len , j-i+1);
            if(a > sum){
                while(a > sum) a -= arr[i++];
                if(a == sum) len = Math.max(len , j-i+1);
            }
            
            j++;
        }
        return len;
    }
}