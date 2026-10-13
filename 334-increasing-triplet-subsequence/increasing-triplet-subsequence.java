class Solution {
    public boolean increasingTriplet(int[] arr) {
        int n =arr.length;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = 0;
        for(int i=0; i<n; i++){
            c = arr[i];
            if(a >= c) a = c;
            else if(b >= c) b = c;
            else if(a < b && b < c) return true;
        }
        return false;
    }
}