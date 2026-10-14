class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(9*num < sum) return "";
        StringBuilder str = new StringBuilder();
        while(num != 0 && sum != 0){
            int s = Math.min(9 , sum);
            str.append(Integer.toString(s));
            sum -= s;
            num--;
        }
        while(num !=0) {
            str.append('0');
            num--;
        }    
        return str.toString();
    }
}