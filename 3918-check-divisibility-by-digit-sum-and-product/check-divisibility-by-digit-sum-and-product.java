class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int x = n;
        while(x != 0){
            int r = x%10;
            sum += r;
            product *= r;
            x /=10;
        }
        int ans = sum + product;
        return ((n%ans)==0) ? true : false;
    }
}