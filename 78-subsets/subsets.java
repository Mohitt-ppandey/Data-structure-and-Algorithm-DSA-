class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        sets(arr , ans , a , 0);
        return ans;
    }
    public static void sets(int[] arr , List<List<Integer>> ans , ArrayList<Integer> a , int idx){
        if(idx >= arr.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        sets(arr , ans , a , idx+1);
        a.add(arr[idx]);
        sets(arr , ans , a , idx+1);
        a.remove(a.size()-1);
    }
}