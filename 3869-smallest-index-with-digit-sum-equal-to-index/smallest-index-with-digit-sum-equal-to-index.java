class Solution {
    public int smallestIndex(int[] arr) {
        int ans =-1;
        for(int i=0; i<arr.length; i++){
            if(fxn(arr[i]) == i) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public int fxn(int x){
        int sum = 0;
        int a = x;
        while(a != 0){
            int rem = a%10;
            sum += rem;
            a /= 10;
        }
        return sum;
    }
}