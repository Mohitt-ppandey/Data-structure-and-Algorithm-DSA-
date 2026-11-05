class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int count = 0;
        long x = Math.abs((long)divisor);
        long y = Math.abs((long)dividend);
        while(y >= x){
            int pow = 0;
            while(y > (x<<pow+1)) pow++;
            count += 1<<pow;
            y -= (x<<pow);
        }
        return ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? count : -count;
    }
}