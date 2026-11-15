class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int)1e9 + 7;
        long odd = 0;
        long even = 1;
        long sum = 0;
        long ans = 0;

        for(int ele : arr) {
            sum += ele;
            if(sum % 2 == 0) {
                ans += odd;
                even++;
            }
            else {
                ans += even;
                odd++;
            }
            ans %= mod;
        }

        return (int)ans;
    }
}