class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans , "" , 0 , 0 , n);
        return ans;
    }
    public void generate(List<String> ans , String str , int open , int close , int n){
        if(close == n) {
            ans.add(str);
            return;
        }
        if(open < n) generate(ans , str+"(" , open+1 , close , n);
        if(close < open) generate(ans , str+")" , open , close+1 , n);
    }
}