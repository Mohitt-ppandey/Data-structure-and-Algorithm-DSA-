class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans , "" , 0 , 0 , n);
        return ans;
    }
    public void generate(List<String> ans , String str , int lb , int rb , int n){
        if(rb == n) {
            ans.add(str);
            return;
        }
        if(lb < n) generate(ans , str+"(" , lb+1 , rb , n);
        if(rb < lb) generate(ans , str+")" , lb , rb+1 , n);
    }
}